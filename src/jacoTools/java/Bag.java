package jacoTools.java;
import java.util.Iterator;
/**
 * Created by Jaco on 14-11-14.
 */
public class Bag<Item> implements Iterable<Item>{
    private Node first;
    private class Node{
        Item item;
        Node next;
    }

    public void add(Item elem){
            Node aux = new Node();
            aux.item = elem;
            aux.next = first;
            first = aux;
    }

    public Iterator<Item> iterator(){
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
