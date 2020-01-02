package brown.communication.messages.library;

import brown.communication.messages.IUtilityUpdateMessage;
import brown.user.agent.IAgent;

public abstract class AbsBankUpdateMessage extends AbsServerToAgentMessage
    implements IUtilityUpdateMessage {

  private Double money;

  public AbsBankUpdateMessage(Integer messageID, Integer agentID,
      Double money) {
    super(messageID, agentID);
    this.money = money;
  }

  public Double getMoneyAddedLost() {
    return this.money;
  }

  @Override
  public void agentDispatch(IAgent agent) {
    agent.onBankUpdate(this);
  }

  @Override
  public String toString() {
    return "AbsBankUpdateMessage [money=" + money + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((money == null) ? 0 : money.hashCode());
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
    AbsBankUpdateMessage other = (AbsBankUpdateMessage) obj;
    if (money == null) {
      if (other.money != null)
        return false;
    } else if (!money.equals(other.money))
      return false;
    return true;
  }

}
