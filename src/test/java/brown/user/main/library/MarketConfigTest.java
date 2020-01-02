package brown.user.main.library;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import brown.auction.rules.IActivityRule;
import brown.auction.rules.IInformationRevelationPolicy;
import brown.auction.rules.IInnerIRPolicy;
import brown.auction.rules.IQueryRule;
import brown.auction.rules.ITerminationCondition;
import brown.auction.rules.IUtilityRule;
import brown.platform.game.IFlexibleRules;
import brown.platform.game.library.FlexibleRules;
import brown.user.main.IMarketConfig; 

public class MarketConfigTest {
  
  @Test
  public void testMarketConfigOne() {
    IUtilityRule mockAllocationRule = mock(IUtilityRule.class); 
    IQueryRule mockQueryRule = mock(IQueryRule.class);
    IActivityRule mockActivityRule = mock(IActivityRule.class); 
    IInformationRevelationPolicy mockIR = mock(IInformationRevelationPolicy.class); 
    ITerminationCondition mocktCondition = mock(ITerminationCondition.class); 
    IInnerIRPolicy innerIR = mock(IInnerIRPolicy.class); 
    
    IFlexibleRules mRules = new FlexibleRules(mockAllocationRule, mockQueryRule, mockActivityRule, mockIR, innerIR, mocktCondition); 
    List<String> tradeableNames = new LinkedList<String>(); 
    tradeableNames.add("default"); 

    IMarketConfig mConfig = new MarketConfig(mRules, tradeableNames); 
    assertEquals(mConfig.getRules(), mRules); 
    assertEquals(mConfig.getTradeableNames(), tradeableNames); 
    
  }
  
}
