import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {

    private List<LineSegment> segments;

    public BruteCollinearPoints(Point[] points){    // finds all line segments containing 4 points
        if(points == null) throw new IllegalArgumentException("Not a valid argument input");
        checkDuplicatePoints(points);
        segments = new ArrayList<>();
        Point[] aux = Arrays.copyOf(points, points.length);
        Arrays.sort(aux);
        for (int i = 0; i < aux.length; i++){
            if(points[i] == null) throw new IllegalArgumentException("Not valid");
            for (int j = i + 1; j < aux.length; j++){
                if(points[j] == null) throw new IllegalArgumentException("Not valid");
                for (int k = j + 1; k < aux.length; k++){
                    if(points[k] == null) throw new IllegalArgumentException("Not valid");
                    for (int l = k + 1; l < aux.length; l++){
                        if(points[l] == null) throw new IllegalArgumentException("Not valid");
                        Point p1 = aux[i];
                        Point p2 = aux[j];
                        Point p3 = aux[k];
                        Point p4 = aux[l];
                        if (p1.slopeTo(p2) == p1.slopeTo(p3)
                                && p1.slopeTo(p3) == p1.slopeTo(p4)) {
                            p1.drawTo(p4);
                            segments.add(new LineSegment(p1, p4));
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments(){  // the number of line segments
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


    public static void main(String[] args) {
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        System.out.println(collinear.numberOfSegments());
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}
