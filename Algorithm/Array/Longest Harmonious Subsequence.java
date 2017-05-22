//leetcode 594 easy
The new function!! getOrDefault is a simplied version of checking whether the map contains the key or not and update the value. !!!
we store long type in hashmap to avoid integer overflow problem. instead of tracking the maximum and minimum number in the array, we iterate
the keyset of the hashmap, and to find whether the map has the next one to decide whether it can be considered or not.
public class Solution {
    public int findLHS(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();
        for (long a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int result = 0;
        for (long a: map.keySet()) {
            if(map.containsKey(a + 1)) {
                result = Math.max(result, map.get(a) + map.get(a + 1));
            }
        }
        return result;
    }
}
