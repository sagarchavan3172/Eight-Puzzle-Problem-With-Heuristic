
public class State {

	int[] currntBoard = new int[9];
	int[] GoalBoard = new int[] { 1, 2, 3, 8, 0, 4, 7, 6, 5 };
	int fuctionCost = 0;

	State() {

		/* Easy */ // currntBoard = new int[] {1,3,4,8,6,2,7,0,5};
		/* Medium */ // currntBoard = new int[] {2,8,1,0,4,3,7,6,5};
		/* Hard */ currntBoard = new int[] { 2, 8, 1, 4, 6, 3, 0, 7, 5 };

	}

	int getHole() {
		int holeIndex = -1;

		for (holeIndex = 0; holeIndex < 9; holeIndex++) {
			if (currntBoard[holeIndex] == 0) {
				return holeIndex;
			}
		}
		return holeIndex;
	}

	boolean checkIfGoalState() {

		for (int i = 0; i < 9; i++) {

			if (this.currntBoard[i] != this.GoalBoard[i]) {
				return false;
			}
		}

		return true;
	}

}// End of Class
