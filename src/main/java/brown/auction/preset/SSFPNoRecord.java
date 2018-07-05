package brown.auction.preset;

import brown.auction.rules.library.HighestPriceAllocation;
import brown.auction.rules.library.NoRecordKeeping;
import brown.auction.rules.library.OneGrouping;
import brown.auction.rules.library.OneShotActivity;
import brown.auction.rules.library.OneShotTermination;
import brown.auction.rules.library.SSSPAnonymous;
import brown.auction.rules.library.SimpleFirstPricePayment;
import brown.auction.rules.library.SimpleQuery;
import brown.auction.rules.library.XRoundTermination;

/**
 * rules for a SSFP Server.
 * @author acoggins
 *
 */
public class SSFPNoRecord extends AbsMarketPreset {
  private int numRuns;

  public SSFPNoRecord(int numRuns) {
    super(new HighestPriceAllocation(),
        new SimpleFirstPricePayment(),
        new SimpleQuery(), 
        new OneGrouping(),
        new OneShotActivity(),
        new SSSPAnonymous(),
        new OneShotTermination(), 
        new XRoundTermination(numRuns),
        new NoRecordKeeping());
    this.numRuns = numRuns; 
  }

  @Override
  public AbsMarketPreset copy() {
    return new SSFPNoRecord(this.numRuns);
  }
  
}