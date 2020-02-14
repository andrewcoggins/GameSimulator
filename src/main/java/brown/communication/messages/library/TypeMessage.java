package brown.communication.messages.library;

import brown.auction.type.typespace.ITypeSpace;
import brown.auction.type.valuation.IType;
import brown.communication.messages.ITypeMessage;
import brown.user.agent.IAgent;

public class TypeMessage extends AbsServerToAgentMessage implements ITypeMessage {
  
  private IType valuation; 
  private ITypeSpace typeSpace; 
  
  private int numAgentsInGame; 
  
  public TypeMessage() {
    super(null, null); 
  }
  
  
  public TypeMessage(Integer messageID, Integer agentID, IType valuation, int numAgents, ITypeSpace typeSpace) {
    super(messageID, agentID);
    this.valuation = valuation; 
    this.numAgentsInGame = numAgents; 
    this.typeSpace = typeSpace; 
  }
  

  @Override
  public void agentDispatch(IAgent agent) {
    agent.onTypeMessage(this);
  }
  
  
  public IType getValuation() {
    return this.valuation; 
  }

  
  @Override
  public int getNumAgentsInGame() {
    return this.numAgentsInGame;
  }


  @Override
  public ITypeSpace getTypeSpace() {
    return this.typeSpace;
  }


  @Override
  public String toString() {
    return "TypeMessage [valuation=" + valuation + ", typeSpace=" + typeSpace
        + ", numAgentsInGame=" + numAgentsInGame + "]";
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + numAgentsInGame;
    result = prime * result + ((typeSpace == null) ? 0 : typeSpace.hashCode());
    result = prime * result + ((valuation == null) ? 0 : valuation.hashCode());
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
    TypeMessage other = (TypeMessage) obj;
    if (numAgentsInGame != other.numAgentsInGame)
      return false;
    if (typeSpace == null) {
      if (other.typeSpace != null)
        return false;
    } else if (!typeSpace.equals(other.typeSpace))
      return false;
    if (valuation == null) {
      if (other.valuation != null)
        return false;
    } else if (!valuation.equals(other.valuation))
      return false;
    return true;
  }

}
