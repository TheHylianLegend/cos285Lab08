public class InsertTTF extends TwoThreeFourTree {

    public void insert(int data) {
        Node current = root;
        while (true) {
            if (current.isFull()) {
                split(current);
                current = current.getParent();
                current = getNextChild(current, data);
            } else if (current.isLeaf()) {
                break;
            } else {
                current = getNextChild(current, data);
            }
        }
        current.insertItem(data);
    }

    private void split(Node thisNode) {
        // Implement splitting logic here
    }

    private Node getNextChild(Node theNode, int theValue) {
        // Logic to decide which child node to descend to
        // Implement child selection logic here
    }

	@Override
	public void insert(Comparable data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Comparable data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comparable[] getSorted() {
		// TODO Auto-generated method stub
		return null;
	}

    // Node class and other helper methods
}

