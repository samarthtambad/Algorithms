

/*------------------------------------------------------------------------------------------------------------------
    Author: Samarth Tambad
    Class Name: RandomizedQueue.java
    Dependencies:
    Compile: javac RandomizedQueue.java
    Run: java RandomizedQueue.java
    Description: This class implements Randomized Queue
------------------------------------------------------------------------------------------------------------------*/

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;

    public RandomizedQueue(){   // construct an empty randomized queue
        items = (Item[]) new Object[1];
        size = 0;
    }

    public boolean isEmpty(){   // is the randomized queue empty?
        return (size == 0);
    }

    public int size(){      // return the number of items on the randomized queue
        return size;
    }

    public void enqueue(Item item) {   // add the item
        if(item == null) throw new IllegalArgumentException("Value of item is not valid");
        size++;
        if(items.length <= size) {
            resize(2 * items.length);
            items[size - 1] = item;
        } else {
            items[size - 1] = item;
        }
    }

    public Item dequeue() {    // remove and return a random item
        if(isEmpty()) throw new NoSuchElementException("Cannot delete from empty queue");
        int randIndex = StdRandom.uniform(size);
        Item randItem = items[randIndex];
        if(size - 1 == randIndex){
            items[randIndex] = null;
        } else {
            items[randIndex] = items[size - 1];
            items[size - 1] = null;
        }
        size--;
        if(size == items.length / 4) resize(items.length / 2);
        return randItem;
    }

    public Item sample() {       // return a random item (but do not remove it)
        if(isEmpty()) throw new NoSuchElementException("Empty queue");
        return items[StdRandom.uniform(size)];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item>{

        private int i = 0;
        private int[] indices;

        public RandomizedQueueIterator(){
            indices = new int[size];
            for (int j = 0; j < indices.length; j++){
                indices[j] = j;
            }
            StdRandom.shuffle(indices);
        }

        @Override
        public boolean hasNext() {
            return (i < size);
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException("No more items in iteration.");
            return items[indices[i++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is unsupported");
        }
    }

    private void resize(int capacity)
    {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            copy[i] = items[i];
        items = copy;
    }

}
