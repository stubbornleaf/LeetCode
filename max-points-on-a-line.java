/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length == 0) {
            return 0;
        }
        
        int max = 1;
        Double zero = new Double(0);
        HashMap<Point, HashMap<Double, HashSet<Point>>> pointsMap = new HashMap<>();
        
        for (int i = 0; i < points.length; i++) {
            pointsMap.put(points[i], new HashMap<Double, HashSet<Point>>());
        }
        
        for (int i = 0; i < points.length; i++) {
            Point point = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Double gradient;
                Point compared = points[j];
                if ((point.x - compared.x) == 0 && (point.y - compared.y) == 0) {
                    gradient = zero;
                } else if ((point.x - compared.x) == 0 || (point.y - compared.y) == 0) {
                    // Use max and min to indicate points on x or y axis.
                    if ((point.x - compared.x) == 0) {
                        gradient = Double.MAX_VALUE;
                    } else {
                        gradient = Double.MIN_VALUE;
                    }
                } else {
                    gradient = new Double((double)(point.x - compared.x) / (double)(point.y - compared.y));
                }
                
                HashMap<Double, HashSet<Point>> pointMap = pointsMap.get(point);
                if (pointMap.containsKey(gradient)) {
                    HashSet<Point> set = pointMap.get(gradient);
                    set.add(compared);
                } else {
                    HashSet<Point> set = new HashSet<>();
                    set.add(point);
                    set.add(compared);
                    pointMap.put(gradient, set);
                }
            }
        }
        
        for (Point point : pointsMap.keySet()) {
            HashMap<Double, HashSet<Point>> pointMap = pointsMap.get(point);
            int repeat = pointMap.containsKey(zero) ? pointMap.get(zero).size() - 1 : 0;
            for (Double gradient : pointMap.keySet()) {
                if (gradient != 0) {
                    // If there are multi points with same x and y as the current point, add repeat times to count.
                    if (pointMap.get(gradient).size() + repeat > max) {
                        max = pointMap.get(gradient).size() + repeat;
                    }
                } else {
                    if (pointMap.get(gradient).size() > max) {
                        max = pointMap.get(gradient).size();
                    }
                }
            }
        }
        
        return max;
    }
}
