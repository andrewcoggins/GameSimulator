package brown.auction.rules.library; 

import brown.auction.marketstate.IMarketState;
import brown.auction.rules.IInnerTC;
import brown.logging.Logging;

public class OneShotTermination implements IInnerTC {

  // If there are bids then a round has happened
  @Override
  public void innerTerminated(IMarketState state) {    
    boolean over = state.getBids().size() > 0; 
    if (state.getOuterOver()){
      over = true;
    }
    state.setInnerOver(over);
    
  }

  @Override
  public void reset() {
  }  
}