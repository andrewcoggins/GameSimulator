package brown.rules.paymentrules.library;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import brown.accounting.MarketState;
import brown.accounting.Order;
import brown.accounting.bidbundle.library.ComplexBidBundle;
import brown.market.marketstate.IMarketState;
import brown.rules.paymentrules.IPaymentRule;
import brown.todeprecate.PaymentType;
import brown.tradeable.library.ComplexTradeable;
import brown.tradeable.library.Tradeable;

/**
 * naive first price payment rule.
 * @author andrew
 *
 */
public class ComFirstPricePayment implements IPaymentRule {

  @Override
  public void setPayments(IMarketState state) {
    // TODO Auto-generated method stub
    List<Order> orders = new LinkedList<Order>();
    ComplexBidBundle original = (ComplexBidBundle) state.getbundleReserve();
    Map<Set<Tradeable>, MarketState> originalMap = original.getBids().bids;
    for (Set<Tradeable> aSet :originalMap.keySet()) {
     double price = originalMap.get(aSet).PRICE;
     int recipient = originalMap.get(aSet).AGENTID;
     ComplexTradeable comTradeable = new ComplexTradeable(0, aSet);
     orders.add(new Order(recipient, null, price, 1, comTradeable));
    }
   state.setPayments(orders);
  }

  @Override
  public void setPaymentType(IMarketState state) {
    // TODO Auto-generated method stub
    state.setPaymentType(PaymentType.FirstPrice);
  }

  @Override
  public void setReserve(IMarketState state) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void permitShort(IMarketState state) {
    // TODO Auto-generated method stub
    
  }
  
}