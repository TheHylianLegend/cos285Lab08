
public class InsertTTF extends TwoThreeFourTree {

	@Override
	public void insert(Comparable data) {
		// TODO Auto-generated method stub
		Node current = root ;
		
		while(true) {
			if(current.isFull()) {
				split(current);
				
				current = current.getParent();
				current = getNextChild(current, data);
				
		
				
				
			}
			
		}
		
		
	}

	private TwoThreeFourTree.Node getNextChild(TwoThreeFourTree.Node current, Comparable data) {
		// TODO Auto-generated method stub
		return null;
	}

	private void split(TwoThreeFourTree.Node current) {
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

}
