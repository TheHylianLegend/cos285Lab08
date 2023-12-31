public class InsertTTF<E extends Comparable<E>> extends TwoThreeFourTree<E> {

    /**
     *@author Herve Badege
     *@author Ashley Pike
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
            } else if (current.isLeaf()) {
                break;
            } else {
                current = getNextChild(current, data);
            }
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


    @Override
    public boolean contains(E data) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public E[] getSorted() {
        // TODO Auto-generated method stub
        return null;
    }
}

