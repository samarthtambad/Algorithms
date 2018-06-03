import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class FastCollinearPoints {

    public FastCollinearPoints(Point[] points){     // finds all line segments containing 4 or more points
        if(points == null) throw new IllegalArgumentException("Not a valid argument input");
        checkDuplicatePoints(points);
        Point[] aux = Arrays.copyOf(points, points.length);
        for (Point origin:points){
            Arrays.sort(aux, origin.slopeOrder());
        }
    }

    public int numberOfSegments(){      // the number of line segments
        return 0;
    }

    public LineSegment[] segments(){    // the line segments
        return null;
    }

    private void checkDuplicatePoints(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if ((points[i].compareTo(points[j]) == 0)) {
                    throw new IllegalArgumentException("Duplicated points were found");
                }
            }
        }
    }

    public static void main(String[] args){
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}
