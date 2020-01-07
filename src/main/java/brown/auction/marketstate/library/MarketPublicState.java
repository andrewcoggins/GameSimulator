package brown.auction.marketstate.library;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import brown.auction.marketstate.IMarketState;
import brown.communication.messages.IActionMessage;
import brown.communication.messages.IActionRequestMessage;
import brown.platform.accounting.IAccountUpdate;

/**
 * Standard MarketState stores the internal information of a market.
 * 
 * @author acoggins
 */
public class MarketPublicState implements IMarketState {

  private int ticks;
  private long time;

  // history
  private List<List<IActionMessage>> tradeHistory;

  // Utility rule
  private List<IAccountUpdate> payments;

  // Query rule
  private IActionRequestMessage tRequest;

  // Activity rule
  private Boolean isAcceptable;
  // activity rule also deals with reserve prices. 
  private Map<String, Double> reserves;

  // Termination condition
  private boolean isOpen;

  public MarketPublicState() {
    this.payments = new LinkedList<IAccountUpdate>();
    this.time = System.currentTimeMillis();
    this.isOpen = true;
    this.tradeHistory = new LinkedList<List<IActionMessage>>();
  }

  @Override
  public void tick() {
    this.ticks++;
  }

  @Override
  public int getTicks() {
    return this.ticks;
  }

  @Override
  public long getTime() {
    return this.time;
  }

  @Override
  public void close() {
    this.isOpen = false;
  }

  @Override
  public boolean isOpen() {
    return this.isOpen;
  }

  // TODO: clearAllocation()
  // Maybe rename this method clearPayments:
  @Override
  public void clearOrders() {
    this.setUtilities(new LinkedList<IAccountUpdate>());
  }

  @Override
  public IActionRequestMessage getTRequest() {
    return this.tRequest;
  }

  @Override
  public void setTRequest(IActionRequestMessage t) {
    this.tRequest = t;
  }

  @Override
  public boolean getAcceptable() {
    return isAcceptable;
  }

  @Override
  public void setAcceptable(boolean acceptable) {
    this.isAcceptable = acceptable;
  }

  @Override
  public List<IAccountUpdate> getUtilities() {
    return this.payments;
  }

  @Override
  public void setUtilities(List<IAccountUpdate> payments) {
    this.payments = payments;
  }

  @Override
  public List<List<IActionMessage>> getTradeHistory() {
    return this.tradeHistory;
  }

  @Override
  public void addToTradeHistory(List<IActionMessage> tradeMessages) {
    this.tradeHistory.add(tradeMessages);
  }

  @Override
  public Map<String, Double> getReserves() {
    return this.reserves; 
  }

  @Override
  public void setReserves(Map<String, Double> reserves) {
    this.reserves = reserves; 
  }

  @Override
  public String toString() {
    return "MarketPublicState [ticks=" + ticks + ", time=" + time
        + ", tradeHistory=" + tradeHistory + ", payments=" + payments
        + ", tRequest=" + tRequest + ", isAcceptable=" + isAcceptable
        + ", reserves=" + reserves + ", isOpen=" + isOpen + "]";
  }
  
  

}
