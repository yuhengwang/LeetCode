
There's no edge case for this question. The initial step is to extend the window to its limit, that is, the longest we 
    can get to with maximum number of modifications. Until then the variable start will remain at 0.

Then as end increase, the whole substring from 0 to end will violate the rule, so we need to update start accordingly
(slide the window). We move start to the right until the whole string satisfy the constraint again. Then each time we 
reach such situation, we update our max length.

class Solution {
    public int characterReplacement(String s, int k) {
        //sliding window
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] count = new int[26];
        int start = 0;
        int maxCount = 0;//the highest occurence of one character in the string
        int len = 1;
        for (int end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            //end - start + 1 - maxCount means the minimum number of changed it has to made to achieve same repeating characters
            if (end - start + 1 - maxCount > k) {
                //remove the one on the start
                count[s.charAt(start) - 'A']--;
                start++;
            }
            //end - start + 1 is not changed if we add end by 1 and add start by 1.
            len = Math.max(len, end - start + 1);
        }
        return len;
    }
}
