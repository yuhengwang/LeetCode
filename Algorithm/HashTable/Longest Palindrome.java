we need to extract every pair of the characters!!!! 
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] array = s.toCharArray();
        int pair = 0;
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                set.remove(array[i]);
                pair++;
            } else {
                set.add(array[i]);
            }
        }
        return set.size() == 0 ? 2 * pair : 2 * pair + 1;
        
    }
}
