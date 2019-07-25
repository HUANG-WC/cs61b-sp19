public class LinkedListDeque<element> implements Deque<element>{
    private Node sentiner;
    private int size=0;


    public class Node {
        public Node front,last;
        public element item;
        public Node(element i ,Node f,Node l){
            item=i;
            front=f;
            last=l;

        }

    }

    /**
     * construct a Deque;
     */
    public  LinkedListDeque(){
        sentiner=new Node(null,null,null);
        sentiner.front=sentiner;
        sentiner.last=sentiner;
    }

    /**
     * add the item to the front of the Deque;
     * @param item
     */
    @Override
    public void addLast(element item){
        Node  A = new Node(item, sentiner, sentiner.last);
        sentiner.last.front=A;
        sentiner.last=A;
        size+=1;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void addFirst(element item){
        Node A=new Node(item,sentiner.front,sentiner);
        sentiner.front.last=A;
        sentiner.front=A;
        size+=1;
    }
    @Override
    public element removeLast(){
        if (size == 0) {
            return null;
        } else {
            Node res = sentiner.last;
            sentiner.last.last.front  =sentiner;
            sentiner.last = sentiner.last.last;
            size -= 1;
            return res.item;
        }

    }
    @Override
    public element removeFirst(){
        if (size == 0) {
            return null;
        } else {
            Node res = sentiner.front;
            sentiner.front.front.last  =sentiner;
            sentiner.front = sentiner.front.front;
            size -= 1;
            return res.item;
        }

    }
    @Override
    public void printDeque() {
        Node ptr=sentiner.front;
        for (int i = 0; i < size; i++) {
            System.out.print(ptr.item);
            ptr=ptr.front;
        }
        System.out.println();
    }
    @Override
    public element getRecursive(int index) {
        if (index < 0 || index >= size){
            return null;
        }
        return Recurhelp(sentiner.front,index);

    }
    private element Recurhelp(Node ptr,int n) {
        if (n == 0) {
            return ptr.item;
        } else {
            return Recurhelp(ptr.front, n-1);
        }
    }
    @Override
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * get the ith item from deque starting at the front(begins at front(if not such item,return null)
     * @param i the ith position;
     * @return the ith item;
     */
    @Override
    public element get (int i){
        Node ptr=sentiner.front;
        if (i >= size) {
            return null;
        }
        while(i>0){
            i-=1;
            ptr=ptr.front;
        }
        return ptr.item;

    }




}
