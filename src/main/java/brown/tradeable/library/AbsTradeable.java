package brown.tradeable.library;

import brown.tradeable.ITradeable;
import brown.tradeable.TradeableType;

public abstract class AbsTradeable implements ITradeable { 
  
  public final Integer ID;
  public Integer COUNT; // Java flaw: final type cannot be inherited! UGH!
  public final TradeableType TYPE; 
  
  /**
   * For Kryo
   * DO NOT USE
   */
  public AbsTradeable() {
    this.ID = 0; 
    this.COUNT = 0; 
    this.TYPE = null;
  }
  
  public AbsTradeable(Integer ID, Integer count, TradeableType type) {
   this.ID = ID; 
   this.COUNT = count;
   this.TYPE = type;
  }

  public Integer getID() {
    return this.ID;
  }
  
  public Integer getCount() {
    return this.COUNT;
  }

  public TradeableType getType() {
    return this.TYPE;
  }
  
  @Override
  public String toString() {
    return "AbsTradeable [ID=" + ID + ", COUNT=" + COUNT + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((COUNT == null) ? 0 : COUNT.hashCode());
    result = prime * result + ((ID == null) ? 0 : ID.hashCode());
    return result;
  }
  
}