import org.hamcrest.internal.ArrayIterator;

import java.awt.desktop.SystemSleepEvent;
import java.util.Iterator;

public class ArraySet <T> implements Iterable<T> {
    T[] items;
    int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }
    public  Iterator<T> iterator() {
        return new ArrayIterator();
    }
    public  class  ArrayIterator implements  Iterator <T> {
        int ptr;
        public  ArrayIterator() {
            ptr =0;
        }
        public  boolean hasNext() {
            return ptr < size ;
        }
        public T next() {
            T res = items[ptr];
            ptr += 1;
            return  res;
        }
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0 ; i < size; i++) {
            if ( x.equals( items[i] )) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if ( x == null ) {
            return;
        } else if ( contains( x)){
            return;
        } else {
            items[size] = x;
            size += 1;
        }
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
        Iterator<String> seer = s.iterator();
        while ( seer.hasNext() ) {
            System.out.println(seer.next());
        }


    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
