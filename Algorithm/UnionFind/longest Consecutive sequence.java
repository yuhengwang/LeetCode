union find的理念
如果我们遇到重复的数，就略过。没遇到一个数的时候，看看数字的-1和+1是否存在在hashmap中， 如果存在的话，就把数列拼起来。
并且更新一下数列的边界。如果之后数列有延伸的话，可以保证长度是一直updated的
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (map.containsKey(n)) continue;
            int left = map.getOrDefault(n - 1, 0);
            int right = map.getOrDefault(n + 1, 0);
            int size = left + 1 + right;
            max = Math.max(max, size);
            map.put(n, size);
            //update boundary
            map.put(n - left, size);
            map.put(n + right, size);
        }
        return max;
    }
}
