//in case of TLE, we create two boolean matrix to check whether s.substring(i, j) is a word, and whether it is possible to 
partition at ith position. 

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (wordDict == null || wordDict.size() == 0) {
            return res;
        }
        //boolean isWord
        boolean[][] isWord = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (wordDict.contains(s.substring(i, j + 1))) {
                    isWord[i][j] = true;
                }
            }
        }
        //boolean possible
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
        dfs(res, s, 0, "", isWord, possible);
        return res;
    }
    public void dfs(List<String> res, String s, int start, String temp, boolean[][] isWord, boolean[] possible) {
        if (!possible[start]) {
            return;
        }
        if (start == s.length()) {
            res.add(temp.trim());
            return;
        }
        // brute force the partition point
        for (int i = start; i < s.length(); i++) {
            String t = s.substring(start, i + 1);
            if (possible[start] && isWord[start][i]) {
                temp = temp + t + " ";
                dfs(res, s, i + 1, temp, isWord, possible);
            } else {
                continue;
            }
            int index = temp.trim().lastIndexOf(" ");
            temp = temp.substring(0, index + 1);
        }
    
    }
}
