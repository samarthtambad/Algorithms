package astar;

import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;

public class Board {

    private final int N;
    private int[] board;
    private int blank_idx = 0;

    public Board(int[][] blocks){   // construct a board from an n-by-n array of blocks (where blocks[i][j] = block in row i, column j)
        if(blocks == null) throw new IllegalArgumentException("board can't be null");
        N = blocks.length;
        board = new int[N * N];
        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if(blocks[i][j] != 0) board[i * N + j] = blocks[i][j];
                else blank_idx = i * N + j;
            }
        }
    }

    private Board(int[] board) {            // private constructor useful in twin()
        if(board == null) throw new IllegalArgumentException("board can't be null");
        N = (int) Math.sqrt(board.length);
        this.board = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            if(board[i] != 0) this.board[i] = board[i];
            else blank_idx = i;
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
        for (int i = 0; i < N * N - 1; i++)
            if (board[i] != i + 1)
                return false;
        return true;
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
        Queue<Board> q = new Queue<>();

        if (blank_idx / N != 0) {                      // if not first row
            Board neighbour = new Board(board);
            exch(neighbour, blank_idx, blank_idx - N);  // exchange with upper block
            neighbour.blank_idx = blank_idx - N;
            q.enqueue(neighbour);
        }

        if (blank_idx / N != (N - 1)) {               // if not last row
            Board neighbour = new Board(board);
            exch(neighbour, blank_idx, blank_idx + N);  // exchange with lower block
            neighbour.blank_idx = blank_idx + N;
            q.enqueue(neighbour);
        }

        if ((blank_idx % N) != 0) {                        // if not leftmost column
            Board neighbour = new Board(board);
            exch(neighbour, blank_idx, blank_idx - 1);  // exchange with left block
            neighbour.blank_idx = blank_idx - 1;
            q.enqueue(neighbour);
        }

        if ((blank_idx % N) != N - 1) {                          // if not rightmost column
            Board neighbour = new Board(board);
            exch(neighbour, blank_idx, blank_idx + 1);  // exchange with left block
            neighbour.blank_idx = blank_idx + 1;
            q.enqueue(neighbour);
        }

        return q;
    }

    public String toString(){       // string representation of this board
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < board.length; i++) {
            s.append(String.format("%2d ", board[i]));
            if ((i+1) % N == 0)
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
        a.board[i] = a.board[j];
        a.board[j] = temp;
        return a;
    }

}
