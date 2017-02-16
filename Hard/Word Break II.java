public class Solution {
    /**
     * @param s a string
     * @param wordDict a set of words
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (wordDict == null || wordDict.size() == 0) {
            return res;
        }
        boolean[][] isWord = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String word = s.substring(i, j + 1);
                isWord[i][j] = wordDict.contains(word);
            }
        }
        boolean[] possible = new boolean[s.length() + 1];
        possible[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (isWord[i][j] && possible[j + 1]) {
                    possible[i] = true;
                    break;
                }
            }
        }
        helper(s, res, wordDict, 0, "", isWord, possible);
        return res;
    }
    public void helper(String s, List<String> res, Set<String> wordDict, int startIndex, String newString
                        , boolean[][] isWord,  boolean[] possible) {
        if (!possible[startIndex]) {
            return;
        }
        if (startIndex == s.length()) {
            res.add(newString.trim());
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String temp = s.substring(startIndex, i + 1);
            if (isWord[startIndex][i] && possible[startIndex]) {
                newString = newString + temp + " ";
            } else {
                continue;
            }
            helper(s, res, wordDict, i + 1, newString, isWord, possible);
            int a = newString.trim().lastIndexOf(" ");
            newString = newString.substring(0,a + 1);
            
        }
       
        
    }
}
