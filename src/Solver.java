import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.MinPQ;

import java.util.Iterator;

public class Solver {

    MinPQ<SearchNode> pq, pqTwin;
    private Board initial;

    private class SearchNode implements Comparable<SearchNode> {
        private Board board;
        private int moves;
        private int priority;
        private SearchNode predecessor;
        public SearchNode(Board b, int m, SearchNode p){
            board = b;
            moves = m;
            predecessor = p;
            priority = moves + board.manhattan();
        }

        @Override
        public int compareTo(SearchNode that) {
            return (this.priority - that.priority);
        }
    }

    public Solver(Board initial){   // find a solution to the initial board (using the A* algorithm)

        if(initial == null) throw new  NullPointerException();

        this.initial = initial;
        pq = new MinPQ<SearchNode>();
        pqTwin = new MinPQ<SearchNode>();

        SearchNode minNode = null;
        SearchNode minNodeTwin = null;
        pq.insert(new SearchNode(initial, 0, null));
        pqTwin.insert(new SearchNode(initial.twin(), 0, null));

        System.out.println(pq.min().board.toString());

        while(!pq.min().board.isGoal() && !pqTwin.min().board.isGoal()){
            minNode = pq.delMin();
            minNodeTwin = pqTwin.delMin();

            for(Board neighbour: minNode.board.neighbors()){
                if(minNode.predecessor == null || !neighbour.equals(minNode.predecessor.board)){
                    pq.insert(new SearchNode(neighbour, minNode.moves + 1, minNode));
                }
            }

            for(Board neighbour: minNodeTwin.board.neighbors()){
                if(minNodeTwin.predecessor == null || !neighbour.equals(minNodeTwin.predecessor.board)){
                    pqTwin.insert(new SearchNode(neighbour, minNodeTwin.moves + 1, minNodeTwin));
                }
            }

        }

    }

    public boolean isSolvable(){    // is the initial board solvable?
        if (pq.min().board.isGoal()) {
            return true;
        }
        if (pqTwin.min().board.isGoal()) {
            return false;
        }
        return false;
    }

    public int moves(){     // min number of moves to solve initial board; -1 if unsolvable
        if(!isSolvable()) return -1;
        return pq.min().moves;
    }

    public Iterable<Board> solution(){      // sequence of boards in a shortest solution; null if unsolvable
        if(!isSolvable()) return null;
        Stack<Board> stackSolution = new Stack<Board>();
        SearchNode current = pq.min();
        while (current.predecessor!=null) {
            stackSolution.push(current.board);
            current = current.predecessor;
        }
        stackSolution.push(initial);
        return stackSolution;
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

//        System.out.println(initial.toString());
//        System.out.println("-------------------------");
//        System.out.println(initial.hamming());
//        System.out.println(initial.manhattan());
//        System.out.println(initial.twin().toString());
//        Iterator<Board> i = initial.neighbors().iterator();
//        while (i.hasNext()){
//            System.out.println(i.next().toString());
//        }


        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

}
