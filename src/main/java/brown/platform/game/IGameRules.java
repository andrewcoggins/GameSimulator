package brown.platform.game;

import brown.auction.rules.IActivityRule;
import brown.auction.rules.IInformationRevelationPolicy;
import brown.auction.rules.IInnerIRPolicy;
import brown.auction.rules.IQueryRule;
import brown.auction.rules.ITerminationCondition;
import brown.auction.rules.IUtilityRule;

/**
 * IMarketRules encapsulates the rules that define a Market. 
 * 
 * @author andrewcoggins
 *
 */
public interface IGameRules {
  
  /**
   * get AllocationRule
   * @return
   */
  public IUtilityRule getARule();
  
  /**
   * get QueryRule
   * @return
   */
  public IQueryRule getQRule(); 
  
  /**
   * get ActivityRule
   * @return
   */
  public IActivityRule getActRule(); 
  
  /**
   * get InformationRevelationPolicy
   * @return
   */
  public IInformationRevelationPolicy getIRPolicy(); 
  
  /**
   * get InnerIRPolicy
   * @return
   */
  public IInnerIRPolicy getInnerIRPolicy(); 
  
  /**
   * get TerminationCondition
   * @return
   */
  public ITerminationCondition getTerminationCondition(); 

}
