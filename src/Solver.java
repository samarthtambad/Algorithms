import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Solver {

    public Solver(Board initial){   // find a solution to the initial board (using the A* algorithm)

    }

    public boolean isSolvable(){    // is the initial board solvable?
        return false;
    }

    public int moves(){     // min number of moves to solve initial board; -1 if unsolvable
        return 0;
    }

    public Iterable<Board> solution(){      // sequence of boards in a shortest solution; null if unsolvable
        return null;
    }

    public static void main(String[] args){     // solve a slider puzzle
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        System.out.println(initial.dimension());
        System.out.println(initial.hamming());
        System.out.println(initial.manhattan());

        /*
        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }*/
    }

}
