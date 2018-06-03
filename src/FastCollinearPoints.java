import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.*;

public class FastCollinearPoints {

    private List<LineSegment> segments;

    public FastCollinearPoints(Point[] points){     // finds all line segments containing 4 or more points
        if(points == null) throw new IllegalArgumentException("Not a valid argument input");
        checkDuplicatePoints(points);
        segments = new ArrayList<>();
        Point[] aux = Arrays.copyOf(points, points.length);
        for (int i = 0;i < points.length; i++){
            Point origin = points[i];
            Arrays.sort(aux, origin.slopeOrder());
            int j = i;
            while(aux[i + 3] != null){
                if((origin.slopeTo(aux[i+1]) == origin.slopeTo(aux[i+2])) && (origin.slopeTo(aux[i+2]) == origin.slopeTo(aux[i+3]))){
                    origin.drawTo(aux[i+3]);
                    segments.add(new LineSegment(origin, aux[i+3]));
                }
            }
        }
    }

    public int numberOfSegments(){      // the number of line segments
        return segments.size();
    }

    public LineSegment[] segments(){    // the line segments
        return segments.toArray(new LineSegment[segments.size()]);
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
        In in = new In("input40.txt");
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
        System.out.println(collinear.numberOfSegments());
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}
