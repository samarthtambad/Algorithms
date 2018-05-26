
/*------------------------------------------------------------------------------------------------------------------
    Author: Samarth Tambad
    Class Name: Permutation.java
    Dependencies: Iterator
    Compile: javac Permutation.java
    Run: java Permutation.java
    Description: This class implements a Double Ended Queue (Deque)
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
