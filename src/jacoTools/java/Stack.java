/**
 * Created by Jaco on 15-10-21.
 */
package jacoTools.java;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private int N;
    private Node first;

    private class Node{
        Item val;
        Node next;
    }

    public void push(Item x){
        N++;
        Node oldfirst = first;
        first = new Node();
        first.val = x;
        first.next = oldfirst;
    }

    public Item pop(){
        if(N > 0){
            Item elem = first.val;
            first = first.next;
            N--;
            return elem;
        }
        else throw new RuntimeException("No items");
    }

    public boolean isEmputy(){
        return N == 0;
    }

    public int size(){ return N;}

    public Iterator<Item> iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }

        public Item next(){
            Item elem = current.val;
            current = current.next;
            return elem;
        }

        @Override
        public void remove() {

        }
    }


}
