package brown.auction.type.typespace;

public class TypeSpace implements ITypeSpace {

  
  private Double lowerBound; 
  private Double upperBound; 
  private boolean isDiscrete; 
  
  
  public TypeSpace(Double lowerBound, Double upperBound, boolean isDiscrete) {
    this.lowerBound = lowerBound; 
    this.upperBound = upperBound; 
    this.isDiscrete = isDiscrete; 
  }
  
  @Override
  public Double getLowerBound() {
    return this.lowerBound;
  }

  @Override
  public Double getUpperBound() {
    return this.upperBound;
  }

  @Override
  public boolean isDiscrete() {
    return this.isDiscrete;
  }

  @Override
  public String toString() {
    return "TypeSpace [lowerBound=" + lowerBound + ", upperBound=" + upperBound
        + ", isDiscrete=" + isDiscrete + "]";
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (isDiscrete ? 1231 : 1237);
    result =
        prime * result + ((lowerBound == null) ? 0 : lowerBound.hashCode());
    result =
        prime * result + ((upperBound == null) ? 0 : upperBound.hashCode());
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
    TypeSpace other = (TypeSpace) obj;
    if (isDiscrete != other.isDiscrete)
      return false;
    if (lowerBound == null) {
      if (other.lowerBound != null)
        return false;
    } else if (!lowerBound.equals(other.lowerBound))
      return false;
    if (upperBound == null) {
      if (other.upperBound != null)
        return false;
    } else if (!upperBound.equals(other.upperBound))
      return false;
    return true;
  }
  

}
