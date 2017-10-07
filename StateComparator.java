import java.util.Comparator;

public class StateComparator implements Comparator<EightPuzzleState> {

	@Override
	public int compare(EightPuzzleState State1, EightPuzzleState State2) {

		if (State1.currentState.fuctionCost == State2.currentState.fuctionCost)
			return 0;
		else if (State1.currentState.fuctionCost > State2.currentState.fuctionCost)
			return 1;
		else
			return -1;
	}

}
