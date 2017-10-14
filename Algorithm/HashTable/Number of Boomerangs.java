class Solution {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int d = getDistance(points[i], points[j]);
                if (map.containsKey(d)) {
                    map.put(d, map.get(d) + 1);
                } else {
                    map.put(d, 1);
                }
            }
            for (int v : map.values()) {
                res += v * (v - 1);
            }
            map.clear();
        }
        return res;
    }
    public int getDistance(int[] a, int[] b) {
        return (int)(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
}
