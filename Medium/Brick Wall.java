public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int height = wall.size();
        int width = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int sum = 0;
            for (int j = 0; j < wall.get(i).size(); j++) {
                sum += wall.get(i).get(j);
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1); 
                } else {
                    map.put(sum, 1);
                }
            }
            width = sum;
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int brick = entry.getValue();
            if (entry.getKey() == width) {
               continue;
            }
            if (brick > max) {
                max = brick;
            }
        }
        return max == Integer.MIN_VALUE ? height : height - max;
    }
}
