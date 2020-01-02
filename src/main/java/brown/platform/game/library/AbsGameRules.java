package brown.platform.game.library;

import brown.auction.rules.IActivityRule;
import brown.auction.rules.IInformationRevelationPolicy;
import brown.auction.rules.IInnerIRPolicy;
import brown.auction.rules.IQueryRule;
import brown.auction.rules.ITerminationCondition;
import brown.auction.rules.IUtilityRule;
import brown.platform.game.IGameRules;

/**
 * Describes all the rules for a particular market.
 * 
 * @author acoggins
 */

public abstract class AbsGameRules implements IGameRules {

  public IUtilityRule aRule;
  public IQueryRule qRule;
  public IActivityRule actRule;
  public IInformationRevelationPolicy infoPolicy;
  public IInnerIRPolicy innerIRPolicy; 
  public ITerminationCondition tCondition;

  /**
   * Constructor consists of each of the market rules. 
   * @param aRule
   * @param pRule
   * @param qRule
   * @param oneShotActivity
   * @param infoPolicy
   * @param innerIRPolicy
   * @param tCondition
   */
  public AbsGameRules(IUtilityRule aRule,
      IQueryRule qRule, IActivityRule oneShotActivity,
      IInformationRevelationPolicy infoPolicy, IInnerIRPolicy innerIRPolicy,
      ITerminationCondition tCondition) {
    this.aRule = aRule;
    this.qRule = qRule;
    this.actRule = oneShotActivity;
    this.infoPolicy = infoPolicy;
    this.innerIRPolicy = innerIRPolicy; 
    this.tCondition = tCondition;
  }

  public IUtilityRule getARule() {
    return this.aRule;
  }

  public IQueryRule getQRule() {
    return this.qRule;
  }

  public IActivityRule getActRule() {
    return this.actRule;
  }

  public IInformationRevelationPolicy getIRPolicy() {
    return this.infoPolicy;
  }
  
  public IInnerIRPolicy getInnerIRPolicy() {
    return this.innerIRPolicy; 
  }

  public ITerminationCondition getTerminationCondition() {
    return this.tCondition;
  }

  
  @Override
  public String toString() {
    return "AbsMarketRules [aRule=" + aRule + ", qRule=" + qRule + ", actRule="
        + actRule + ", infoPolicy=" + infoPolicy + ", innerIRPolicy="
        + innerIRPolicy + ", tCondition=" + tCondition + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((aRule == null) ? 0 : aRule.hashCode());
    result = prime * result + ((actRule == null) ? 0 : actRule.hashCode());
    result =
        prime * result + ((infoPolicy == null) ? 0 : infoPolicy.hashCode());
    result = prime * result
        + ((innerIRPolicy == null) ? 0 : innerIRPolicy.hashCode());
    result = prime * result + ((qRule == null) ? 0 : qRule.hashCode());
    result =
        prime * result + ((tCondition == null) ? 0 : tCondition.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AbsGameRules other = (AbsGameRules) obj;
    if (aRule == null) {
      if (other.aRule != null)
        return false;
    } else if (!aRule.equals(other.aRule))
      return false;
    if (actRule == null) {
      if (other.actRule != null)
        return false;
    } else if (!actRule.equals(other.actRule))
      return false;
    if (infoPolicy == null) {
      if (other.infoPolicy != null)
        return false;
    } else if (!infoPolicy.equals(other.infoPolicy))
      return false;
    if (innerIRPolicy == null) {
      if (other.innerIRPolicy != null)
        return false;
    } else if (!innerIRPolicy.equals(other.innerIRPolicy))
      return false;
    if (qRule == null) {
      if (other.qRule != null)
        return false;
    } else if (!qRule.equals(other.qRule))
      return false;
    if (tCondition == null) {
      if (other.tCondition != null)
        return false;
    } else if (!tCondition.equals(other.tCondition))
      return false;
    return true;
  }



}
