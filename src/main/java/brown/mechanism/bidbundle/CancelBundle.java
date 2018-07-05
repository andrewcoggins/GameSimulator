package brown.mechanism.bidbundle;

import brown.mechanism.bid.CancelBid;
import brown.mechanism.bid.IBid;

/**
 * for two sided markets- a bidbundle that cancels
 * a previous order in the orderbook.
 * @author kerry
 *
 */
public class CancelBundle implements IBidBundle {
  private final CancelBid BID;
  private final BundleType BT;
  
  /**
   * For Kryo 
   * DO NOT USE
   */
  public CancelBundle() {
    this.BID = null;
    this.BT = null;
  }
  
  public CancelBundle(CancelBid bid) {
    this.BID = bid;
    this.BT = BundleType.CANCEL;
  }
  
  @Override
  public IBid getBids() {
    return this.BID;
  }

  @Override
  public BundleType getType() {
    return this.BT;
  }

  @Override
  public double getCost() {
    return 0;
  }

}