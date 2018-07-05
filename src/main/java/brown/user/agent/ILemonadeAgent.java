package brown.user.agent;

import brown.mechanism.channel.GameChannel;

public interface ILemonadeAgent {

  /**
   * Provides agent response in lemonade game
   * @param channel - lemonade channel
   */
  public void onLemonade(GameChannel channel);

}