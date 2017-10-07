import java.util.ArrayList;

public class EightPuzzleState {

	EightPuzzleState() {

		parent = null;
		cost = 0;
		hCost = 0;
		fCost = 0;
	}

	EightPuzzleState(State currentState, EightPuzzleState parent, int costToPath) {

		this.currentState = currentState;
		this.parent = parent;

		cost = costToPath;

	}

	EightPuzzleState parent;
	State currentState;

	int cost; // cost to get to this state
	int hCost; // heuristic cost
	int fCost; // f(n) cost

	ArrayList<State> generateChildren() {
		int hole;
		ArrayList<State> childNodes = new ArrayList<State>();

		hole = currentState.getHole();

		if (hole != 0 && hole != 3 && hole != 6) {
			State childNode = new State();
			swap(childNode, hole, hole - 1);

			childNode.fuctionCost = evaluationFunction(childNode);
			childNodes.add(childNode);
		}

		if (hole != 0 && hole != 1 && hole != 2) {
			State childNode = new State();
			swap(childNode, hole, hole - 3);

			childNode.fuctionCost = evaluationFunction(childNode);
			childNodes.add(childNode);
		}

		if (hole != 2 && hole != 5 && hole != 8) {
			State childNode = new State();
			swap(childNode, hole, hole + 1);

			childNode.fuctionCost = evaluationFunction(childNode);
			childNodes.add(childNode);
		}

		if (hole != 6 && hole != 7 && hole != 8) {
			State childNode = new State();
			swap(childNode, hole, hole + 3);

			childNode.fuctionCost = evaluationFunction(childNode);
			childNodes.add(childNode);
		}

		return childNodes;
	}

	int evaluationFunction(State childNode) {

		hCost = getOutOfPlace(childNode);

		fCost = cost + hCost;
		return fCost;
	}

	private int getOutOfPlace(State childNode) {
		int outOfPlace = 0;
		for (int i = 0; i < 9; i++) {
			if (childNode.currntBoard[i] != childNode.GoalBoard[i]) {
				outOfPlace++;
			}
		}

		return outOfPlace;
	}

	boolean equals(State child, State parent) {
		if (parent == null)
			return false;
		for (int i = 0; i < 9; i++) {
			if (child.currntBoard[i] != parent.currntBoard[i])
				return false;
		}

		return true;
	}

	void swap(State childNode, int holePosition, int newHolePosition) {
		int temp;

		for (int i = 0; i < 9; i++) // 4 to 9
		{
			childNode.currntBoard[i] = currentState.currntBoard[i];
		}

		temp = childNode.currntBoard[holePosition];
		childNode.currntBoard[holePosition] = childNode.currntBoard[newHolePosition];
		childNode.currntBoard[newHolePosition] = temp;

	}

	public void printState() {

		System.out.println(currentState.currntBoard[0] + " | " + currentState.currntBoard[1] + " | "
				+ currentState.currntBoard[2]);
		System.out.println("---------");
		System.out.println(currentState.currntBoard[3] + " | " + currentState.currntBoard[4] + " | "
				+ currentState.currntBoard[5]);
		System.out.println("---------");
		System.out.println(currentState.currntBoard[6] + " | " + currentState.currntBoard[7] + " | "
				+ currentState.currntBoard[8]);
	}

}
