import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Queue;

import java.util.Iterator;

public class Board {

    private final int m_dimension;
    private final int[][] m_blocks;
    private final int[][] m_twin;
    private int[][] m_neighbour1;
    private int[][] m_neighbour2;
    private int[][] m_neighbour3;
    private int[][] m_neighbour4;
    private final int m_hamming;
    private final int m_manhattan;
    private final int[] m_blank_idx;

    public Board(int[][] blocks){   // construct a board from an n-by-n array of blocks (where blocks[i][j] = block in row i, column j)

        m_dimension = blocks.length;
        m_blocks = new int[m_dimension][m_dimension];
        for(int i = 0; i < m_dimension; i++){
            m_blocks[i] = blocks[i].clone();
        }

        m_twin = new int[m_dimension][m_dimension];
        m_neighbour1 = new int[m_dimension][m_dimension];
        m_neighbour2 = new int[m_dimension][m_dimension];
        m_neighbour3 = new int[m_dimension][m_dimension];
        m_neighbour4 = new int[m_dimension][m_dimension];
        m_blank_idx = new int[2];
        int hamming = 0, manhattan = 0, counter = 1;
        for(int i = 0; i < m_dimension; i++){     //rows
            for(int j = 0; j < m_dimension; j++){     //cols
                if(m_blocks[i][j] != 0){
                    m_twin[i][j] = m_blocks[i][j];
                    m_neighbour1[i][j] = m_blocks[i][j];
                    m_neighbour2[i][j] = m_blocks[i][j];
                    m_neighbour3[i][j] = m_blocks[i][j];
                    m_neighbour4[i][j] = m_blocks[i][j];
                    if(m_blocks[i][j] != counter) hamming++;
                    int iRow = (m_blocks[i][j] - 1) / m_dimension;
                    int iCol = (m_blocks[i][j] - 1) % m_dimension;
                    manhattan = manhattan + Math.abs(iRow - i) + Math.abs(iCol - j);
                } else {
                    m_blank_idx[0] = i;
                    m_blank_idx[1] = j;
                }
                counter++;
            }
        }
        m_hamming = hamming;
        m_manhattan = manhattan;
    }

    public int dimension(){     // board dimension n
        return m_dimension;
    }

    public int hamming() {     // number of blocks out of place
        return m_hamming;
    }

    public int manhattan(){     // sum of Manhattan distances between blocks and goal
        return m_manhattan;
    }

    public boolean isGoal(){    // is this board the goal board?
        return (hamming() == 0 && manhattan() == 0);
    }

    public Board twin(){    // a board that is obtained by exchanging any pair of blocks
        boolean isChanged = false;
        while (!isChanged){
            int i1 = StdRandom.uniform(m_dimension);
            int j1 = StdRandom.uniform(m_dimension);
            int i2 = StdRandom.uniform(m_dimension);
            int j2 = StdRandom.uniform(m_dimension);
            if(i1 != i2 || j1 != j2){
                if ((m_twin[i1][j1] != 0) && (m_twin[i2][j2] != 0)){
                    swap(m_twin, i1, j1, i2, j2);
                    isChanged = true;
                }
            }
        }
        return new Board(m_twin);
    }

    public boolean equals(Object y){      // does this board equal y?
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board other = (Board) y;
        if(this.dimension() != other.dimension()) return false;
        for (int i = 0; i < this.dimension(); i++){
            for (int j = 0; j < this.dimension(); j++){
                if(this.m_blocks[i][j] != other.m_blocks[i][j]) return false;
            }
        }
        return true;
    }

    public Iterable<Board> neighbors(){     // all neighboring boards
        Queue<Board> neighbours = new Queue<Board>();
        if(m_blank_idx[0]-1 >= 0){  //Above
            swap(m_neighbour1, m_blank_idx[0], m_blank_idx[1], m_blank_idx[0] - 1, m_blank_idx[1]);
            neighbours.enqueue(new Board(m_neighbour1));
        }
        if(m_blank_idx[0]+1 < m_dimension){  //Below
            swap(m_neighbour2, m_blank_idx[0], m_blank_idx[1], m_blank_idx[0] + 1, m_blank_idx[1]);
            neighbours.enqueue(new Board(m_neighbour2));
        }
        if(m_blank_idx[1]-1 >= 0){  //Left
            swap(m_neighbour3, m_blank_idx[0], m_blank_idx[1], m_blank_idx[0], m_blank_idx[1] - 1);
            neighbours.enqueue(new Board(m_neighbour3));
        }
        if(m_blank_idx[1]+1 < m_dimension){  //Right
            swap(m_neighbour4, m_blank_idx[0], m_blank_idx[1], m_blank_idx[0], m_blank_idx[1] + 1);
            neighbours.enqueue(new Board(m_neighbour4));
        }
        return neighbours;
    }

    public String toString(){       // string representation of this board
        StringBuilder s = new StringBuilder();
        s.append(m_dimension + "\n");
        for (int i = 0; i < m_dimension; i++) {
            for (int j = 0; j < m_dimension; j++) {
                s.append(String.format("%2d ", m_blocks[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    private void swap(int[][]a, int i1, int j1, int i2, int j2){
        int temp = a[i1][j1];
        a[i1][j1] = a[i2][j2];
        a[i2][j2] = temp;
    }

}
