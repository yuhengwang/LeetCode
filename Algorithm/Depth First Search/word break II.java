Concise solution, we use HashMap to store temporary result
time complexity O(n3) 
Size of recursion tree can go up to n^2 The creation of list takes n time.
space complexity O(n3)
The depth of the recursion tree can go up to n and each activation record can contains a string list of size n(n * n).

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, LinkedList<String>>());
    }
    public List<String> dfs(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        LinkedList<String> res = new LinkedList<>();
        // when it comes to the end of string
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> temp = dfs(s.substring(word.length()), wordDict, map);
                for (String t : temp) {
                    res.add(word + (t.equals("") ? "" : " " + t));
                }
            }
        }
        map.put(s, res);
        return res;
    }
}


in case of TLE, we create two boolean matrix to check whether s.substring(i, j) is a word, and whether it is possible to 
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
