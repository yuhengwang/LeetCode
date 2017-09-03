GReedy, each time we set the arrow to the end of the interval, if it can cover the next interval, we do not need to add arrow,
if cannot , add one arrow and update the arrow position
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0] == null || points[0].length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int cnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0])   continue;
            cnt++;
            arrowPos = points[i][1];
        }
        return cnt;
    }
}
