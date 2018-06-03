package Deque;
/*------------------------------------------------------------------------------------------------------------------
    Author: Samarth Tambad
    Class Name: Deque.Permutation.java
    Dependencies: Iterator
    Compile: javac Deque.Permutation.java
    Run: java Deque.Permutation.java
    Description: This class implements a Double Ended Queue (Deque.Deque)
------------------------------------------------------------------------------------------------------------------*/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args)
    {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<String>();

        while(!StdIn.isEmpty())
        {
            rq.enqueue(StdIn.readString());
        }
        for(int i=1;i<=k;i++)
        {
            StdOut.println(rq.dequeue());
        }
    }
}
