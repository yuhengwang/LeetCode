//cacualte the shortest distance
Please note!!!
Two-end BFS is used to save time, and we have to transform list to hashset, because the contain function in List cost o(n), 
but the contain function in hashset cost only o(1)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordList = new HashSet<>(wordListOrigin);
    if (beginWord.equals(endWord)) return 1;
    if (!wordList.contains(endWord)) return 0;
        /*if (!wordList.contains(endWord))    return 0;*/
        // Two-end BFS
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int count = 1;
        HashSet<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                HashSet<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            HashSet<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] ch = word.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    char old = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        ch[i] = c;
                        String s = String.valueOf(ch);
                        if (endSet.contains(s)) {
                            return count + 1;
                        }
                        if (!visited.contains(s) && wordList.contains(s)) {
                            temp.add(s);
                            visited.add(s);
                        }
                    }
                    ch[i] = old;
                }
            }
            beginSet = temp;
            count++;
        }
        return 0;
    }
}
