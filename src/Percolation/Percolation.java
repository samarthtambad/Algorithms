package Percolation;

/*------------------------------------------------------------------------------------------------------------------
    Author: Samarth Tambad
    Class Name: Percolation.java
    Dependencies: WeightedQuickUnionUF (algs4.jar)
    Compile: javac Percolation.java
    Run: java Percolation.java
    Description: This class is a model for percolation object. It creates a nxn grid of sites.
    All sites are closed by default. The user can choose to open a site at a given location (row, col).
    The user can also choose to check if the current model percolates i.e. if there is a path b/w any sites at the
    topmost and bottommost layer. The user can also check if the site is open and is the site is full i.e. this site
    is connected to any site at the topmost layer.
    The problem of backwash sometimes presents itself. This problem is also tacked in this code.
------------------------------------------------------------------------------------------------------------------*/

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF grid;
    private WeightedQuickUnionUF fullness;
    private boolean[] isOpen;
    private int dimension;
    private int numOfOpenSites;
    private int virtualTop;
    private int virtualBottom;

    public Percolation (int n) {    // create n-by-n grid, with all sites blocked
        if(n > 0) {
            dimension = n;
            numOfOpenSites = 0;
            virtualTop = indexTo1D(n, n) + 1;
            virtualBottom = indexTo1D(n, n) + 2;
            int numOfSites = n * n;
            isOpen = new boolean[numOfSites];
            grid = new WeightedQuickUnionUF(numOfSites + 2);
            fullness = new WeightedQuickUnionUF(numOfSites + 1);
        } else {
            throw new java.lang.IllegalArgumentException("The value of n must be > 0");
        }
    }

    public void open(int row, int col){     // open site (row, col) if it is not open already
        validate(row, col);
        int currentSite = indexTo1D(row, col);
        if(!isOpen(row, col)){
            isOpen[currentSite] = true;
            numOfOpenSites++;
            if(row == 1){
                grid.union(currentSite, virtualTop);
                fullness.union(currentSite, virtualTop);
            }
            if(row == dimension){
                grid.union(currentSite, virtualBottom);
            }
            if(row > 1 && isOpen((row - 1), col)){
                grid.union(currentSite, indexTo1D((row - 1), col));
                fullness.union(currentSite, indexTo1D((row - 1), col));
            }
            if(row < dimension && isOpen((row + 1), col)){
                grid.union(currentSite, indexTo1D((row + 1), col));
                fullness.union(currentSite, indexTo1D((row + 1), col));
            }
            if(col > 1 && isOpen(row, (col - 1))){
                grid.union(currentSite, indexTo1D(row, (col - 1)));
                fullness.union(currentSite, indexTo1D(row, (col - 1)));
            }
            if(col < dimension && isOpen(row, (col + 1))){
                grid.union(currentSite, indexTo1D(row, (col + 1)));
                fullness.union(currentSite, indexTo1D(row, (col + 1)));
            }
        }
    }

    public boolean isOpen(int row, int col){    // is site (row, col) open?
        validate(row, col);
        return isOpen[indexTo1D(row, col)];
    }

    public boolean isFull(int row, int col){    // is site (row, col) full?
        validate(row, col);
        return fullness.connected(indexTo1D(row, col), virtualTop);
    }

    public int numberOfOpenSites(){     // number of open sites
        return numOfOpenSites;
    }

    public boolean percolates(){    // does the system percolate?
        return grid.connected(virtualTop, virtualBottom);
    }

    private int indexTo1D(int row, int col){    //convert index from 2D (row, col) to 1D for WeightedQuickUnionUF implementation
        validate(row, col);
        row -= 1;
        col -= 1;
        return (row * dimension) + col;
    }

    private boolean isValid(int row, int col){
        row -= 1;
        col -= 1;
        return ((row >= 0 && row < dimension) && (col >= 0 && col < dimension));
    }

    private void validate(int row, int col){
        if(!isValid(row, col)){
            throw new IllegalArgumentException("Not valid values for (row, col)");
        }
    }

}
