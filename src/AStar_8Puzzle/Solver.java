package AStar_8Puzzle;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.MinPQ;

public class Solver {

    private Board initial;
    private SearchNode goal;

    private class SearchNode implements Comparable<SearchNode> {
        private Board board;
        private int moves;
        private int priority;
        private SearchNode predecessor;
        public SearchNode(Board b, int m, SearchNode p){
            board = b;
            moves = m;
            predecessor = p;
            priority = moves + b.manhattan();
        }

        @Override
        public int compareTo(SearchNode that) {
            return (this.priority - that.priority);
        }
    }

    public Solver(Board initial){   // find a solution to the initial board (using the A* algorithm)

        if(initial == null) throw new  NullPointerException();

        MinPQ<SearchNode> pq, pqTwin;
        this.initial = initial;
        pq = new MinPQ<SearchNode>();
        pqTwin = new MinPQ<SearchNode>();

        SearchNode minNode = null;
        SearchNode minNodeTwin = null;
        pq.insert(new SearchNode(initial, 0, null));
        pqTwin.insert(new SearchNode(initial.twin(), 0, null));


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

        goal = pq.min();

    }

    public boolean isSolvable(){    // is the initial board solvable?
        if (goal.board.isGoal()) {
            return true;
        }
        return false;
    }

    public int moves(){     // min number of moves to solve initial board; -1 if unsolvable
        if(!isSolvable()) return -1;
        return goal.moves;
    }

    public Iterable<Board> solution(){      // sequence of boards in a shortest solution; null if unsolvable
        if(!isSolvable()) return null;
        Stack<Board> stackSolution = new Stack<Board>();
        SearchNode current = goal;
        while (current.predecessor!=null) {
            stackSolution.push(current.board);
            current = current.predecessor;
        }
        stackSolution.push(initial);
        return stackSolution;
    }

    public static void main(String[] args){     // solve a slider puzzle
        // create initial board from file
        /*In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

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
