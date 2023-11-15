
public abstract class TwoThreeFourTree<E extends Comparable<E>> {

    protected Node<E> root = new Node<E>();
    
    /**
     * @author Ashley Pike
     * Node class
     */
    protected static class Node<E extends Comparable<E>> {
        protected static final int order = 4;
        protected int size;
        protected Node<E> parent;
        protected Node<E> children[];
        protected E data[];
  
        public Node() {
            data = (E[]) new Comparable[order-1];
            children = (Node<E>[]) new Node[order];
            size = 0;
        }
        
        public void connectChild(int index, Node<E> child) {
            children[index] = child;
            if (child != null)
                child.parent = this;
        }
        
        public Node<E> disconnectChild(int index) {
            Node<E> temp = children[index];
            children[index] = null;
            return temp;
        }
        
        public Node<E> getChild(int index){
            return children[index];
        }
        
        public Node<E> getParent(){
            return parent;
        }
        
        public boolean isLeaf() {
            return (children[0] == null);
        }
        
        public int getSize() {
            return size;
        }
        
        public E getData(int index) {
            return data[index];
        }
        
        public boolean isFull() {
            return (size == (order-1));
        }
        
        public int insertData(E newData) {
            size++;
            
            for (int i = order-2; i >= 0; i--) {
                if (data[i] != null) {
                    if(newData.compareTo(data[i]) < 0)
                        data[i+1] = data[i];
                    else {
                        data[i+1] = newData;
                        return i+1;
                    }
                    
                }
            }
            data[0] = (E) newData;
            return 0;
        }
        
        public E removeData() {
            E temp = data[size-1];
            data[size-1] = null;
            size--;
            return temp;
        }
    }
    
    
    /**
     * @param data
     */
    public abstract void insert(E data);
    /**
     * @param data
     * @return
     */
    public abstract boolean contains(E data);
    /**
     * @return
     */
    public abstract E[] getSorted();
    

}
