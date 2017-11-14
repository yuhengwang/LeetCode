
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        int[] count = new int[256];
        int start = 0;
        int len = 0;
        int num = 0; //number of distinct character
        for (int end = 0; end < s.length(); end++) {
        //enter if statement only when s.charAt(end) is the distinct character until now
            if (count[s.charAt(end)]++ == 0) num++;
            //if the number of distinct exceeds k
            if (num > k) {
            //we need to remove character from start until we totally remove one distinct character
                while (--count[s.charAt(start++)] > 0);
                num--;
            }
            //start - 1 points the last copy of the disapearing character
            //compare
            //1 2 3 4
            //start  end, the length would be 4 -1 + 1 = 4
            len = Math.max(len, end - start + 1);
        }
        return len;
    }
}
