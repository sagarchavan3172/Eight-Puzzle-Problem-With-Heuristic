
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BFSSearch {

	int count = 0;
	ArrayList<EightPuzzleState> open;
	ArrayList<EightPuzzleState> closed;
	Stack<EightPuzzleState> path;

	BFSSearch() {
		open = new ArrayList<EightPuzzleState>();
		closed = new ArrayList<EightPuzzleState>();
		path = new Stack<EightPuzzleState>();
	}

	void startSeach() {
		int parentCost;
		EightPuzzleState rootNode = new EightPuzzleState(new State(), null, 1);

		open.add(rootNode);
		count++;

		while (!open.isEmpty()) {
			Collections.sort(open, new StateComparator());

			EightPuzzleState currentNode = new EightPuzzleState();
			currentNode = open.remove(0);

			// count++;

			if (currentNode.currentState.checkIfGoalState()) {
				System.out.println("Goal State Found");
				System.out.println("Number of Nodes enqueued:" + count);

				EightPuzzleState Node = new EightPuzzleState();

				Node = currentNode;

				path.push(Node);

				while (Node.parent != null) {
					// path.push(item);
					Node = Node.parent;
					path.push(Node);
				}

				while (!path.isEmpty()) {
					System.out.println("\n");
					path.pop().printState();

				}

				break;

			} else {

				ArrayList<State> childNodes = new ArrayList<State>();

				childNodes = currentNode.generateChildren();

				closed.add(currentNode);

				for (State childNode : childNodes) {
					if (!AlreadyEvaluated(childNode)) {
						if (currentNode.parent == null)
							parentCost = 1;
						else
							parentCost = currentNode.parent.cost;
						EightPuzzleState tempNode = new EightPuzzleState(childNode, currentNode, parentCost + 1);

						open.add(tempNode);
						count++;
					}

				}

			}

		}

	}

	boolean AlreadyEvaluated(State childNode) {
		boolean check;

		check = (checkIfStateIsInOpen(childNode) || checkIfStateIsInClosed(childNode)) ? true : false;

		return check;

	}

	boolean checkIfStateIsInOpen(State node) {
		for (EightPuzzleState openNode : open) {
			if (equals(openNode, node))
				return true;
		}

		return false;

	}

	boolean checkIfStateIsInClosed(State node) {

		for (EightPuzzleState closedNode : closed) {
			if (equals(closedNode, node))
				return true;
		}

		return false;
	}

	boolean equals(EightPuzzleState openState, State node) {
		for (int i = 0; i < 9; i++) {
			if (openState.currentState.currntBoard[i] != node.currntBoard[i])
				return false;
		}

		return true;
	}

}
