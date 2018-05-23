/*------------------------------------------------------------------------------------------------------------------
    Author: Samarth Tambad
    Class Name: PercolationStats.java
    Dependencies: Percolation, StdRandom, StdStats, Stopwatch (algs4.jar)
    Compile: javac PercolationStats.java
    Run: java PercolationStats.java
    Description: This class performs the Monte Carlo simulation where series of T trials on percolation models of nxn
    dimension. It then computes the mean, stddev, confidenceLo & confidenceHi (95% confidence) of the percolation thresholds.
    The percolation threshold represents the fraction of filled sites with which the system almost always percolates.
------------------------------------------------------------------------------------------------------------------*/

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {

    private final static double CONFIDENCE_95 = 1.96;
    private final double[] percolationThreshold;
    private final int numOfTrials;

    public PercolationStats(int n, int trials){    // perform trials independent experiments on an n-by-n grid
        Stopwatch timer = new Stopwatch();
        Percolation p;
        numOfTrials = trials;
        int totalNumberOfSites = n * n;
        percolationThreshold = new double[trials];
        for(int i = 0; i < trials; i++){
            p = new Percolation(n);
            while(!p.percolates()){
                int randRow = StdRandom.uniform(n) + 1;
                int randCol = StdRandom.uniform(n) + 1;
                if(!p.isOpen(randRow, randCol)){
                    p.open(randRow, randCol);
                }
            }
            double nos = (double) p.numberOfOpenSites();
            percolationThreshold[i] = nos / totalNumberOfSites;
        }
        double time = timer.elapsedTime();
        System.out.println("N:\t" + n);
        System.out.println("\nTime Elapsed:\t" + time);
    }
    public double mean(){                          // sample mean of percolation threshold
        return StdStats.mean(percolationThreshold);
    }
    public double stddev(){                        // sample standard deviation of percolation threshold
        return StdStats.stddev(percolationThreshold);
    }
    public double confidenceLo(){                  // low  endpoint of 95% confidence interval
        double mean = mean();
        double stddev = stddev();
        return (mean - ((CONFIDENCE_95 * stddev)/Math.sqrt(numOfTrials)));
    }
    public double confidenceHi(){                  // high endpoint of 95% confidence interval
        double mean = mean();
        double stddev = stddev();
        return (mean + ((CONFIDENCE_95 * stddev)/Math.sqrt(numOfTrials)));
    }
    private void displayStats(){
        System.out.println("Trials:\t" + numOfTrials);
        System.out.println("Mean:\t" + mean());
        System.out.println("Std Dev:\t" + stddev());
        System.out.println("Confidence Low:\t" + confidenceLo());
        System.out.println("Confidence High:\t" + confidenceHi());

    }

    public static void main(String args[]){  //For testing only

    }

}