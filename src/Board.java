import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Queue;

import java.util.Arrays;
import java.util.Iterator;

public class Board {

    private final int N;
    private final int[] board;
    private int blank_idx = 0;

    public Board(int[][] blocks){   // construct a board from an n-by-n array of blocks (where blocks[i][j] = block in row i, column j)
        N = blocks.length;
        board = new int[N];
        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if(blocks[i][j] != 0) board[i * N + j] = blocks[i][j];
                else blank_idx = i * N + j;
            }
        }
    }

    private Board(int[] board) {            // private constructor useful in twin()
        N = (int) Math.sqrt(board.length);
        this.board = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            this.board[i] = board[i];
        }
    }

    public int dimension(){     // board dimension n
        return N;
    }

    public int hamming() {     // number of blocks out of place
        int hamming = 0;
        for (int i = 0; i < N * N; i++){
            if (board[i] != i + 1 && board[i] != 0) hamming++;
        }
        return hamming;
    }

    public int manhattan(){     // sum of Manhattan distances between blocks and goal
        int manhattan = 0;
        for (int i = 0; i < N * N; i++){
            if (board[i] != i + 1 && board[i] != 0) manhattan += calcManhattan(board[i], i);
        }
        return manhattan;
    }

    public boolean isGoal(){    // is this board the goal board?
        return (hamming() == 0 && manhattan() == 0);
    }

    public Board twin(){    // a board that is obtained by exchanging any pair of blocks
        if(N == 1) return null;
        Board twin = new Board(board);
        if (board[0] != 0 && board[1] != 0)
            exch(twin, 0, 1);                // if the first two blocks in first row is not empty, exchange them.
        else
            exch(twin, N, N + 1);  // otherwise, exchange the first two blocks on second row.
        return twin;
    }

    public boolean equals(Object y){      // does this board equal y?
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board other = (Board) y;
        return Arrays.equals(this.board, other.board);
    }

    public Iterable<Board> neighbors(){     // all neighboring boards
        Board neighbour;
        Queue<Board> q = new Queue<Board>();

        if (blank_idx / N != 0) {                      // if not first row
            neighbour = new Board(board);
            exch(neighbour, blank_idx, blank_idx - N);  // exchange with upper block
            q.enqueue(neighbour);
        }

        if (blank_idx / N != (N - 1)) {               // if not last row
            neighbour = new Board(board);
            exch(neighbour, blank_idx, blank_idx + N);  // exchange with lower block
            q.enqueue(neighbour);
        }

        if ((blank_idx % N) != 0) {                        // if not leftmost column
            neighbour = new Board(board);
            exch(neighbour, blank_idx, blank_idx - 1);  // exchange with left block
            q.enqueue(neighbour);
        }

        if ((blank_idx % N) != N - 1) {                          // if not rightmost column
            neighbour = new Board(board);
            exch(neighbour, blank_idx, blank_idx + 1);  // exchange with left block
            q.enqueue(neighbour);
        }

        return q;
    }

    public String toString(){       // string representation of this board
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < board.length; i++) {
            s.append(String.format("%2d ", board[i]));
            if (i % N == 0)
                s.append("\n");
        }
        return s.toString();
    }

    private int calcManhattan(int goal, int current) {  // return manhattan distance of a misplaced block
        int row, col;                                                // row and column distance from the goal
        row = Math.abs((goal - 1) / N - current / N);              // row difference
        col = Math.abs((goal - 1) % N - current % N);             // column difference
        return row + col;
    }

    private Board exch(Board a, int i, int j) { // exchange two elements in the array
        int temp = a.board[i];
        a.board[j] = a.board[i];
        a.board[i] = temp;
        return a;
    }

}
