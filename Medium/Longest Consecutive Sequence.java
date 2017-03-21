public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        int longest = 0;
        int down = -1;
        int up = -1;
        for (int i = 0; i < num.length; i++) {
            int number = num[i];
            down = num[i] - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            up = num[i] + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            longest = Math.max(longest, up - down - 1);
        }
        return longest;
    }
}
