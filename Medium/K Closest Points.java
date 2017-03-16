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
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
      
        HashMap<Point, Double> maps = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            maps.put(points[i], caculateDistance(points[i], origin));
        }
        List<Map.Entry<Point, Double>> entries = new ArrayList<Map.Entry<Point, Double>>(maps.size());  
        entries.addAll(maps.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Point, Double>>() {
            @Override
            public int compare(final Map.Entry<Point, Double> entry1, final Map.Entry<Point, Double> entry2){
                if (entry1.getValue().compareTo(entry2.getValue()) == 0) {
                    Point a = entry1.getKey();
                    Point b = entry2.getKey();
                    if (a.x == b.x) {
                        return a.y - b.y;
                    } else {
                        return a.x - b.x;
                    }
                } else 
                    return entry1.getValue().compareTo(entry2.getValue());
            }
        });
        Point[] result = new Point[k];
        for (int j = 0; j < k; j++) {
            result[j] = (Point)(entries.get(j).getKey());
        }
        return result;
    }
    private double caculateDistance(Point a, Point b) {
        return Math.pow((Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2)), 0.5);
    }
}
