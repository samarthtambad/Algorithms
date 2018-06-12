public class Board {

    private final int dimension;
    private final int[][] m_blocks;
    private final int[][] goal;

    public Board(int[][] blocks){   // construct a board from an n-by-n array of blocks (where blocks[i][j] = block in row i, column j)
        m_blocks = blocks;
        dimension = m_blocks.length;
//        goal = new int[dimension][dimension];
//        int counter = 1;
//        for(int i = 0; i < dimension; i++){     //rows
//            for(int j = 0; j < dimension; j++){     //cols
//                if(!(i == dimension-1 && j == dimension-1)){
//                    goal[i][j] = counter;
//                    counter++;
//                }
//            }
//        }
    }

    public int dimension(){     // board dimension n
        return dimension;
    }

    public int hamming() {     // number of blocks out of place
        return 0;
    }

    public int manhattan(){     // sum of Manhattan distances between blocks and goal
        return 0;
    }

    public boolean isGoal(){    // is this board the goal board?
        return false;
    }

    public Board twin(){    // a board that is obtained by exchanging any pair of blocks
        return null;
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
