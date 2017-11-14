class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
         if (s == null || s.length() == 0) {
            return 0;
        }
        int[] count = new int[256];
        int start = 0;
        int len = 0;
        int num = 0; //number of distinct character
        for (int end = 0; end < s.length(); end++) {
            if (count[s.charAt(end)]++ == 0) num++;
            //if the number of distinct exceeds k
            if (num > 2) {
                while (--count[s.charAt(start++)] > 0);
                num--;
            }
            //compare
            len = Math.max(len, end - start + 1);
        }
        return len;
        
    }
}
