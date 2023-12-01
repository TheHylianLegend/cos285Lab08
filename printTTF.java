import java.util.*;

public class printTTF<E extends Comparable<E>> extends TwoThreeFourTree<E> {

	@Override
	public void insert(E data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(E data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/** @author Liban Dahir
	 * Returns an array containing all elements in the tree, sorted from smallest to largest.
	 * This method initiates an in-order traversal of the tree, starting from the root, 
	 * to collect all elements in a sorted manner. If the tree is empty, it returns null.
	 *
	 * @return An array of elements sorted in ascending order, or null if the tree is empty.
	 */
	@Override
	public E[] getSorted() {
        if (root == null) {
            return null;
        }
        List<E> list = new ArrayList<>();
        getSortedHelper(root, list);
        E[] sortedArray = (E[]) new Comparable[list.size()];
        sortedArray = list.toArray(sortedArray);
        return sortedArray;
		System.out.println("Hello World");
    }
	/**
	 * A helper method for the getSorted method. It performs an in-order traversal 
	 * starting from the given node, adding each visited element to the provided list.
	 * This traversal ensures that elements are added in a sorted order.
	 * 
	 * @param node The current node being visited in the traversal.
	 * @param list The list accumulating the sorted elements.
	 */
	 private void getSortedHelper(Node<E> node, List<E> list) {
	        if (node == null) {
	            return;
	        }
	        for (int i = 0; i < node.size; i++) {
	            getSortedHelper(node.children[i], list);
	            list.add(node.data[i]);
	        }
	        getSortedHelper(node.children[node.size], list);
	    }
	}


