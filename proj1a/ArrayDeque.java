/**class  ArrayDeque.
@Huang
*/
public class ArrayDeque<T> {
    private T[] items;
    private  int front, size, maxsize, tail;
    /**construct a ArrayDeque.*/
    public ArrayDeque() {
        front = 0;
        tail = 1;
        size = 0;
        maxsize = 4;
        items = (T[]) new Object[4];
    }
    /**
     * Adding the item to front of the Deque.
     * @param item;
     */
    public void  addFirst(T item) {
        if (size == maxsize) {
            this.resize(maxsize * 2);
        }
        items[front] = item;
        front = circleMinus(front);
        size += 1;
    }

    /**
     * Adding the item to tail of the Deque.
     */
    public void  addLast(T item) {
        if (size == maxsize) {
            this.resize(maxsize * 2);
        }
        items[tail] = item;
        tail = circlePlus(tail);
        size += 1;
    }
    public int circlePlus(int index) {
        return (index + 1) % maxsize;
    }
    public int circleMinus(int index) {
        return (index - 1 + maxsize) % maxsize;
    }

    public void resize(int newsize) {
        T[] temp = (T[]) new Object[newsize];
        front = circlePlus((front));
        for (int i = 0; i < size; i++) {
            temp[i] = items[front];
            front = circlePlus((front));
        }
        items = temp;
        maxsize = newsize;
        front = maxsize - 1;
        tail = size;

    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    /**print all the items of the ArrayDeque.*/
    public void printDeque() {
        int index = circlePlus(front);
        for (int i = 0; i < size; i++) {
            System.out.print(items[index] + " ");
            index = circlePlus(index);
        }
        System.out.println();
    }
    /**remove the front item of the Deque.*/
    public T removeFirst() {
        T res;
        front = circlePlus(front);
        res = items[front];
        items[front] = null;
        size -= 1;
        double a=size;
        if ( a/maxsize < 0.25){
            resize(maxsize / 2);
        }
        return res;

    }
    /**remove the front item of the Deque.*/
    public T removeLast() {
        T res;
        tail = circleMinus(tail);
        res = items[tail];
        items[tail] = null;
        size -= 1;
        if (size / maxsize < 0.25){
            resize(maxsize / 2);
        }
        return res;
    }
    public T get(int index) {
        if (index < size) {
            return items[circlePlus(index + front)];
        } else {
            return null;
        }
    }

}
