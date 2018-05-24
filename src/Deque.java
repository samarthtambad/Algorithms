

/*------------------------------------------------------------------------------------------------------------------
    Author: Samarth Tambad
    Class Name: Deque.java
    Dependencies: Iterator
    Compile: javac Deque.java
    Run: java Deque.java
    Description: This class implements a Double Ended Queue (Deque)
------------------------------------------------------------------------------------------------------------------*/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node{
        Item item;
        Node next;
    }
    private Node first, last;
    private int size;

    public Deque(){   // construct an empty deque
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty(){   // is the deque empty?
        return (first == null);
    }

    public int size(){      // return the number of items on the deque
        return size;
    }

    public void addFirst(Item item){    // add the item to the front
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if(last == null){
            last = first;
        }
        size++;
    }

    public void addLast(Item item){     // add the item to the end
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(oldLast != null){
            oldLast.next = last;
        }
        if(first == null){
            first = last;
        }
        size++;
    }

    public Item removeFirst(){      // remove and return the item from the front
        if(first == null){
            throw new NoSuchElementException("No items present to remove");
        }
        Item item = first.item;
        if (first == last){
            last = null;
        }
        first = first.next;
        size--;
        return item;
    }

    public Item removeLast(){       // remove and return the item from the end
        if(first == null){
            throw new NoSuchElementException("No items present to remove");
        }
        Item item = null;
        if(first == last){
            item = last.item;
            first = null;
            last = null;
        }else{
            Node secondLast = first;
            while(secondLast.next != last){
                secondLast = secondLast.next;
            }
            secondLast.next = null;
            item = last.item;
            last = secondLast;
        }
        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {      // return an iterator over items in order from front to end
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{

        private Node current = first;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public Item next() {
            if(current == null){
                throw new NoSuchElementException("No more items left");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is unsupported");
        }
    }

    public static void main(String[] args){
//        Deque<Integer> deque = new Deque<Integer>();
//        deque.addFirst(3);
//        deque.addLast(4);
//        deque.addFirst(2);
//        deque.addFirst(1);
//        deque.addLast(5);
//        deque.addLast(6);
//        deque.addLast(7);
//        deque.addFirst(9);
//        System.out.println(deque.removeFirst());
//        System.out.println(deque.removeLast());
//        Iterator<Integer> iterator = deque.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
    }

}
