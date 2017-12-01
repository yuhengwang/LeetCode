similar to 2 sum but it is 2 difference
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //0,1,2,3
        //0 00 0 0 0 0 0 
        //a - b = k
        for (int i = 0; i < sum.length; i++) {
            if (map.containsKey(sum[i])) {
                List<Integer> indice = map.get(sum[i]);
                count += indice.size();
            }
            if (map.containsKey(sum[i] + k)) {
                map.get(sum[i] + k).add(i);
            } else {
                List<Integer> values = new ArrayList<>();
                values.add(i);
                map.put(sum[i] + k, values);
            }
        }
        return count;
    }
}
