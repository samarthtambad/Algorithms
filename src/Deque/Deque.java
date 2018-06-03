package Deque;

/*------------------------------------------------------------------------------------------------------------------
    Author: Samarth Tambad
    Class Name: Deque.Deque.java
    Dependencies: Iterator
    Compile: javac Deque.Deque.java
    Run: java Deque.Deque.java
    Description: This class implements a Double Ended Queue (Deque.Deque)
------------------------------------------------------------------------------------------------------------------*/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size;

    private class Node{
        Item item;
        Node next;
        Node prev;
    }

    public Deque(){   // construct an empty deque
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty(){   // is the deque empty?
        return (size == 0);
    }

    public int size(){      // return the number of items on the deque
        return size;
    }

    public void addFirst(Item item){    // add the item to the front
        if(item == null) throw new IllegalArgumentException("Cannot add null item.");
        Node newFirst = new Node();
        newFirst.item = item;
        newFirst.prev = null;
        if(size == 0){
            newFirst.next = null;
            first = newFirst;
            last = newFirst;
        } else {
            newFirst.next = first;
            first.prev = newFirst;
            first = newFirst;
        }
        size++;
    }

    public void addLast(Item item){     // add the item to the end
        if(item == null) throw new IllegalArgumentException("Cannot add null item.");
        Node newLast = new Node();
        newLast.item = item;
        newLast.next = null;
        if(size == 0){
            newLast.next = null;
            first = newLast;
            last = newLast;
        } else{
            newLast.prev = last;
            last.next = newLast;
            last = newLast;
        }
        size++;
    }

    public Item removeFirst(){      // remove and return the item from the front
        if(isEmpty()) throw new NoSuchElementException("No items present to remove");
        Item item = first.item;
        if(size == 1) {
            first = null;
            last = null;
        } else {
            Node temp = first;
            first = first.next;
            first.prev = null;
            temp.next = null;
            temp = null;
        }
        size--;
        return item;
    }

    public Item removeLast(){       // remove and return the item from the end
        if(isEmpty()) throw new NoSuchElementException("No items present to remove");
        Item item = last.item;
        if(size == 1) {
            first = null;
            last = null;
        } else {
            Node temp = last;
            last = last.prev;
            last.next = null;
            temp.prev = null;
            temp = null;
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

//        Deque.Deque<Integer> deque = new Deque.Deque<Integer>();
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
//        System.out.println(deque.removeLast());
//        System.out.println(deque.removeLast());
//        System.out.println(deque.removeLast());
//        System.out.println(deque.removeLast());
//        System.out.println(deque.removeLast());
//        System.out.println(deque.removeLast());

    }

}
