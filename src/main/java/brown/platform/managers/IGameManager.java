package brown.platform.managers;

import java.util.List;
import java.util.Map;

import brown.auction.type.valuation.IType;
import brown.communication.messages.IActionMessage;
import brown.communication.messages.IActionRequestMessage;
import brown.communication.messages.IInformationMessage;
import brown.communication.messages.ISimulationReportMessage;
import brown.communication.messages.IStatusMessage;
import brown.platform.accounting.IAccountUpdate;
import brown.platform.game.IFlexibleRules;
import brown.platform.game.IGame;

/**
 * IMarketManager creates and stores all IMarket in a simulation
 * @author andrewcoggins
 *
 */
public interface IGameManager {

  /**
   * creates a block of Markets. These will be run simultaneously in the simulation
   * @param rules
   * rules of each market
   * @param marketItems
   * items to be run in each market. the first set of rules is opened with the first ICart... 
   */
  public void createSimultaneousGame(List<IFlexibleRules> rules);

  /**
   * lock the manager. After this method is called, no more markets may be created. 
   */
  public void lock();
  
  /**
   * get the number of simultaneous markets stored in the manager. 
   * @return
   */
  public Integer getNumMarketBlocks(); 
  
  /**
   * 
   * @param index
   * @param agents
   * @param groupIndex
   * @param numGroups
   */
  public void openMarkets(int index, Map<Integer, IType> agents, int groupIndex, int numGroups); 
  
  /**
   * handle a tradeMessage, meaning to redirect it to its intended market. 
   * @param message ITradeMessage from an agent
   * @return
   * IStatusMessage specifying whether or not the ITradeMessage was rejected or not. 
   */
  public IStatusMessage handleTradeMessage(IActionMessage message); 
  
  /**
   * get the IDs of all the active, open markets. 
   * @return
   */
  public List<Integer> getActiveMarketIDs(); 
  
  /**
   * return an active market by its market ID. 
   * @param marketID the id of the market to be retrieved. 
   * @return
   */
  public IGame getActiveMarket(Integer marketID); 
  
  /**
   * update a market, so that it runs a 'cycle', and return a List of TradeRequestMessage
   * to be sent to agents
   * @param marketID
   * ID of market to be udpated. 
   * @param agents
   * List of Integer of all agents that are registered in the Simulation. 
   * @return
   * List<ITradeRequestMessage> to be sent to agents. 
   */
  public List<IActionRequestMessage> updateMarket(Integer marketID); 
  
  /**
   * constructs information message to be sent back to agents. 
   * @param marketID
   * ID of markets that information messages are for. 
   * @param agentIDs
   * IDs of agents in the simulation
   * @return
   * a map from each agent's ID to its information message. 
   */
  public Map<Integer, IInformationMessage> constructInformationMessages(Integer marketID, List<Integer> agentIDs); 
  
  /**
   * constructs simulation report messages. 
   * @param agentIDs
   * @return a map from agent IDs to their simulation report messages. 
   */
  public Map<Integer, ISimulationReportMessage>
  constructSimulationReportMessages(List<Integer> agentIDs); 
  
  /**
   * run the final 'closing' round of a market. 
   * @param marketID
   * ID of market to be finished. 
   * @return
   * List<IAccountUpdate> reflecting the outcome of the auction. 
   */
  public List<IAccountUpdate> finishMarket(Integer marketID); 
  
  /**
   * remove a market from the list of active markets
   * @param marketID
   * ID of market to be finalized.
   */
  public void finalizeMarket(Integer marketID); 
  
  /**
   * returns whether or not a market is open, or active. 
   * @param marketID
   * ID of market to check
   * @return
   */
  public boolean marketOpen(Integer marketID); 
  
  /**
   * checks if any market is open. 
   * @return
   */
  public boolean anyMarketsOpen(); 
  
  /**
   * resets the manager at the end of a simulation; clears all active markets, 
   * set the run index to 0, clears the whiteboard(s)
   */
  public void reset(); 
  
}
