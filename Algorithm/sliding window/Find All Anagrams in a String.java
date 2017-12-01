class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];
        List<Integer> res = new ArrayList<>();
        if (s == null ||s.length() == 0 || p == null || s.length() < p.length())  {
            return res;
        }
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        int left = 0; int right = 0; int total = p.length();
        while (right < s.length()) {
             //move right everytime, if the character exists in p's hash, decrease the count
        //current hash value >= 1 means the character is existing in p
            if (count[s.charAt(right++) - 'a']-- >= 1)   total--;
            if (total == 0)
                res.add(left);
             //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
        //++ to reset the hash because we kicked out the left
        //only increase the count if the character is in p
        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && count[s.charAt(left++) - 'a']++ >= 0)   total++;
            
        }
        return res;
    }
}
