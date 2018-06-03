import java.util.ArrayList;
import java.util.List;

public class BruteCollinearPoints {

    private List<LineSegment> segments;

    public BruteCollinearPoints(Point[] points){    // finds all line segments containing 4 points
        if(points == null) throw new IllegalArgumentException("Not a valid argument input");
        checkDuplicatePoints(points);
        segments = new ArrayList<>();
        for (int i = 0; i < points.length; i++){
            for (int j = 1; j < points.length; j++){
                for (int k = 2; k < points.length; k++){
                    if (points[i].slopeOrder().compare(points[j], points[k]) == 0){
                        for (int l = 3; l < points.length; l++){
                            if(points[i].slopeOrder().compare(points[j], points[l]) == 0){
                                if ((points[i].compareTo(points[j]) < 0) && (points[j].compareTo(points[k]) < 0) && (points[k].compareTo(points[l]) < 0)){
                                    segments.add(new LineSegment(points[i], points[j]));
                                }
                            }
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
        return (LineSegment[]) segments.toArray();
    }

    private void checkDuplicatePoints(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if ((points[i].compareTo(points[j]) == 0) || points[i] != null || points[j] != null) {
                    throw new IllegalArgumentException("Duplicated points were found");
                }
            }
        }
    }

}
