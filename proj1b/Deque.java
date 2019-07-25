public interface Deque <element> {
    public void addLast(element item);
    public void addFirst(element item);
    public element removeLast();
    public element removeFirst();
    public void printDeque();
    public element getRecursive(int index);
    public element get (int i);
    public boolean isEmpty();
    public int size();
    public static void main (String[] arg) {
        Deque A = new LinkedListDeque();
    }
}
