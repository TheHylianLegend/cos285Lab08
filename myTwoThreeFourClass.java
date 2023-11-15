import java.util.ArrayList;
import java.util.List;

public class myTwoThreeFourClass<E extends Comparable<E>> extends TwoThreeFourTree<E>{

    public static void main(String[] args) {
        myTwoThreeFourClass<Integer> TTF = new myTwoThreeFourClass<Integer>();
        TTF.insert(3);
        TTF.insert(5);
        TTF.insert(7);
        TTF.insert(17);
        TTF.insert(4);
        TTF.insert(6);
        TTF.insert(9);
        
        Object[] x = TTF.getSorted();
        for (int i = 0; i < x.length; i++)
            System.out.println(x[i]);

    }

    /**
     * @author Herve Badege
     * @author Ashley Pike
     * Inserts data into TwoThreeFourTree,
     * splitting nodes if needing while traversing to leaf node
     * 
     * @param data to insert
     */
    @Override
    public void insert(E data) {
        Node<E> current = root;
        
        while (true) {
            if (current.isFull()) {
                split(current);
                current = current.getParent();
                current = getNextChild(current, data);
            } else if (current.isLeaf())
                break;
              else 
                current = getNextChild(current, data);
        }
        current.insertData(data);
    }

    
    /**
     * @author Ashley Pike
     * Splits 4-node into 2 2-nodes
     * with middle value being added to parent node
     * 
     * @param 4-node to split
     */
    private void split(Node<E> node) {
        E tempData1, tempData2;
        Node<E> parent, child2, child3;
        int dataIndex;
        
        tempData2 = node.removeData();
        tempData1 = node.removeData();
        child2 = node.disconnectChild(2);
        child3 = node.disconnectChild(3);
        
        Node<E> newRight = new Node<E>();
        
        if (node == root) {
            root = new Node<E>();
            parent = root;
            root.connectChild(0, node);
        } else
            parent = node.getParent();
        
        dataIndex = parent.insertData(tempData1);
        int s = parent.getSize();
        
        for (int i = s - 1; i > dataIndex; i--) {
            Node<E> temp = parent.disconnectChild(i);
            parent.connectChild(i+1, temp);
        }
        parent.connectChild(dataIndex+1, newRight);
        newRight.insertData(tempData2);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }
    
    /**
     * @author Ashley Pike
     * Finds the next child node to traverse to
     *
     * @param node to find child of
     * @param data to compare to
     * @return next child of node
     */
    private Node<E> getNextChild(Node<E> node, E data){
        int i;
        int size = node.getSize();
        
        for (i = 0; i < size; i++) {
            if (data.compareTo(node.getData(i)) < 0)
                return node.getChild(i);
        }
        
        return node.getChild(i);
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

    @Override
    public boolean contains(E data) {
        // TODO Auto-generated method stub
        return false;
    }
}