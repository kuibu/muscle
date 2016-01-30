package jacoTools.java;
import java.util.Iterator;
/**
 * Created by Jaco on 14-11-18.
 */
public class Queue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int count;
    private class Node{
        T item;
        Node next;
    }

    public void enqueue(T item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(first == null) first = last;
        else oldlast.next = last;
        count++;

    }

    public int size(){ return count;}
    public boolean isEmputy(){ return first != null;}

    public T dequeue(){
        if(first == null) return null;
        T re = first.item;
        first = first.next;
        if(count == 1) last = null;
        count--;
        return re;
    }

    public Iterator<T> iterator(){
        return new QIterator();
    }

    private class QIterator implements Iterator<T>{
        private Node current = first;
        @Override
        public void remove() {

        }

        public boolean hasNext(){
            return current != null;
        }

        public T next(){
            T item = current.item;
            current = current.next;
            return item;
        }
    }

}
