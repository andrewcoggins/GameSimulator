package brown.rules.library; 

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import brown.bid.interim.BidType;
import brown.bidbundle.BundleType;
import brown.bidbundle.IBidBundle;
import brown.bidbundle.library.AuctionBidBundle;
import brown.logging.Logging;
import brown.market.library.PrevStateInfo;
import brown.market.library.PrevStateType;
import brown.market.library.PriceDiscoveryInfo;
import brown.market.marketstate.IMarketState;
import brown.messages.library.TradeMessage;
import brown.rules.IAllocationRule;
import brown.tradeable.ITradeable;
import brown.tradeable.library.SimpleTradeable;
import brown.tradeable.library.TradeableType;

/**
 * highest bidder allocation with reserve.
 * @author acoggins
 *
 */
public class HPReserveAllocation implements IAllocationRule {

  @Override
  public void setAllocation(IMarketState state) {
    // TODO Auto-generated method stub
    PrevStateInfo prev = state.getPrevState(); 
    if (prev.getType() == PrevStateType.DISCOVERY) {  
      PriceDiscoveryInfo pdInfo = (PriceDiscoveryInfo) prev;  
      IBidBundle reserve = pdInfo.reservePrices; 
      state.setReserve(reserve); 
    }
    //
    
    IBidBundle reserves = state.getReserve(); 
    AuctionBidBundle reservePrices = (AuctionBidBundle) reserves; 
    
    // a grouping is a list of lists of agent IDs.
    List<List<Integer>> grouping = state.getGroups();       
    Map<Integer,List<ITradeable>> alloc = new HashMap<Integer,List<ITradeable>>();

    for (List<Integer> group : grouping) {
      // What do you have to allocate
      List<SimpleTradeable> temp = new LinkedList<SimpleTradeable>();
      for (ITradeable t : state.getTradeables()){
        temp.addAll(t.flatten());
      }
      // Check that this is a set (SSSP doesn't make sense with duplicates)
      Set<SimpleTradeable> toAllocate = new HashSet<SimpleTradeable>();
      for (SimpleTradeable t : temp) {
        if (!toAllocate.contains(t)) {
          toAllocate.add(t);
        } else {
          Logging.log("[x] Highest Price Allocation: Initialized goods are not a set");
        }
      }
      
      Map<SimpleTradeable, Double> highestPrice = new HashMap<SimpleTradeable, Double>();
      Map<SimpleTradeable, Integer> highestAgent = new HashMap<SimpleTradeable, Integer>();
      
      List<TradeMessage> allBids = state.getBids();             
      for(TradeMessage bid : allBids) {      
        // Bid must be of right type
        if(bid.Bundle.getType().equals(BundleType.AUCTION) &&
           group.contains(bid.AgentID)) {
          AuctionBidBundle bundle = (AuctionBidBundle) bid.Bundle; 
          for (ITradeable t : bundle.getBids().bids.keySet()) {
            // This only works with SIMPLE Tradeables          
            if (t.getType() != TradeableType.Simple){
              Logging.log("[x] SSSP Allocation: Bid on non-Simple Tradeable");
            }
            // If either there are no bids for this yet or this bid is higher than those
            Map<ITradeable, BidType> reserveMap = reservePrices.getBids().bids; 
            if(highestPrice.get(t) == null || highestPrice.get(t) < bundle.getBids().bids.get(t).price) {
              if (reserveMap.containsKey(t)) {
                if (bundle.getBids().bids.get(t).price > reservePrices.getBids().bids.get(t).price) {
                  // Store the highest price and the corresponding agent
                  highestPrice.put((SimpleTradeable) t, bundle.getBids().bids.get(t).price);
                  highestAgent.put((SimpleTradeable) t, bid.AgentID);
                }
              } else { 
                // Store the highest price and the corresponding agent
                highestPrice.put((SimpleTradeable) t, bundle.getBids().bids.get(t).price);
                highestAgent.put((SimpleTradeable) t, bid.AgentID);
              }
            } else if (highestPrice.get(t) == bundle.getBids().bids.get(t).price && Math.random() > 0.5){
              if (reserveMap.containsKey(t)) {
                if (bundle.getBids().bids.get(t).price > reservePrices.getBids().bids.get(t).price) {
                  // Store the highest price and the corresponding agent
                  highestPrice.put((SimpleTradeable) t, bundle.getBids().bids.get(t).price);
                  highestAgent.put((SimpleTradeable) t, bid.AgentID);
                }
              } else { 
                highestPrice.put((SimpleTradeable) t, bundle.getBids().bids.get(t).price);
                highestAgent.put((SimpleTradeable) t, bid.AgentID); 
              }             
            }
          }
        }
      }
      
      for (Entry<SimpleTradeable,Integer> item : highestAgent.entrySet()){
        Integer agentID = item.getValue();
        List<ITradeable> toAdd = new LinkedList<ITradeable>();
        // Check that we are not double allocating stuff
        if (toAllocate.contains(item.getKey())){
          toAllocate.remove(item.getKey());
        } else {
          Logging.log("[x] SSSPAllocation: Overallocated Good");
        }
        toAdd.add(item.getKey());
        if (!alloc.containsKey(agentID)){
          alloc.put(agentID, toAdd);
        } else {
          alloc.get(agentID).addAll(toAdd);
        }
      }    
    }
    state.setAllocation(alloc);
  }

  @Override
  public void reset() {
    // TODO Auto-generated method stub
    
  }
  
  
}