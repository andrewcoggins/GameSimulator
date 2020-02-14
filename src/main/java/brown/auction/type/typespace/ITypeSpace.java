package brown.auction.type.typespace;

public interface ITypeSpace {
  
  /**
   * get lower bound of the type space. 
   * @return
   */
  public Double getLowerBound(); 
  
  /**
   * get upper bound of the type space. 
   * @return
   */
  public Double getUpperBound(); 
  
  /**
   * indicates whether type space is discrete or continuous.
   * @return
   */
  public boolean isDiscrete(); 
  
}
