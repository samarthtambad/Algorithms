import edu.princeton.cs.algs4.StdRandom;

public class Board {

    private final int m_dimension;
    private final int[][] m_blocks;
    private final int[][] m_twin;
    private final int m_hamming;
    private final int m_manhattan;
    private final int[] m_blank_idx;

    public Board(int[][] blocks){   // construct a board from an n-by-n array of blocks (where blocks[i][j] = block in row i, column j)
        m_blocks = blocks;
        m_dimension = m_blocks.length;
        m_twin = new int[m_dimension][m_dimension];
        m_blank_idx = new int[2];
        int hamming = 0, manhattan = 0, counter = 1;
        for(int i = 0; i < m_dimension; i++){     //rows
            for(int j = 0; j < m_dimension; j++){     //cols
                if(m_blocks[i][j] != 0){
                    m_twin[i][j] = m_blocks[i][j];
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
            if ((m_twin[i1][j1] != 0) && (m_twin[i2][j2] != 0)){
                int temp = m_twin[i1][j1];
                m_twin[i1][j1] = m_twin[i2][j2];
                m_twin[i2][j2] = temp;
                isChanged = true;
            }
        }
        return new Board(m_twin);
    }

    public boolean equals(Object y){      // does this board equal y?
        return false;
    }

    public Iterable<Board> neighbors(){     // all neighboring boards
        return null;
    }

    public String toString(){       // string representation of this board (in the output format specified below)
        return null;
    }

    public static void main(String[] args){

    }

}
