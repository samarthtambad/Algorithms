public class BruteCollinearPoints {

    public BruteCollinearPoints(Point[] points){    // finds all line segments containing 4 points
        if(points == null){
            throw new IllegalArgumentException("Not a valid argument input");
        }
        for (int i = 0; i < points.length; i++){
            for (int j = 1; j < points.length; j++){
                for (int k = 2; k < points.length; k++){
                    for (int l = 3; l < points.length; l++){
                        
                    }
                }
            }
        }
    }

    public int numberOfSegments(){  // the number of line segments
        return 0;
    }

    public LineSegment[] segments(){    // the line segments
        return null;
    }

}
