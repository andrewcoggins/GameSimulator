package brown.rules.queryrules.library;

import brown.accounting.Ledger;
import brown.accounting.bidbundle.library.SimpleBidBundle;
import brown.channels.MechanismType;
import brown.channels.agent.library.SimpleAgentChannel;
import brown.market.marketstate.IMarketState;
import brown.messages.library.TradeRequestMessage;
import brown.rules.queryrules.IQueryRule;

public class SealedBidQuery implements IQueryRule {

	@Override
	public void makeChannel(IMarketState state, Ledger ledger) {
		//if (state.getAllocation().getType().equals(BundleType.Simple)) {

			state.setTRequest(new TradeRequestMessage(0, 
					new SimpleAgentChannel(state.getID(), ledger, state.getPaymentType(), MechanismType.SealedBid, 
							(SimpleBidBundle) state.getbundleReserve(), state.getEligibility()), 
							MechanismType.SealedBid));
		//}
	}	
}