class TrieNode {
    TrieNode [] children;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
    public void insert(String word, int index) {
        if (index == word.length()) {
            this.isWord = true;
            return;
        }
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index + 1);
    }
    public TrieNode find(String word, int index) {
        if (index == word.length()) {
            return this;
        }
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            return null;
        }
        return children[pos].find(word, index + 1);
    }
}
class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        root.insert(word, 0);
    }
    public boolean find(String word) {
        TrieNode res = root.find(word, 0);
        return res != null && res.isWord;
    }
    public boolean startWith(String word) {
        TrieNode res = root.find(word, 0);
        return res != null;
    }
}
public class Solution {
    public void dfs(char[][] board, int i, int j, String temp, Trie dictionary, boolean[][] visited, Set<String> res) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        temp += board[i][j];
        if (!dictionary.startWith(temp)) {
            return;
        }
        if (dictionary.find(temp)) {
            res.add(temp);
        }
        visited[i][j] = true;
        dfs(board, i + 1, j, temp, dictionary, visited, res);
        dfs(board, i, j + 1, temp, dictionary, visited, res);
        dfs(board, i, j - 1, temp, dictionary, visited, res);
        dfs(board, i - 1, j , temp, dictionary, visited, res);
        visited[i][j] = false;
        
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie dictionary = new Trie();
        for (int i = 0; i < words.length; i++) {
            dictionary.insert(words[i]);
        }
        Set<String> res = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, "", dictionary, visited, res);
            }
        }
        return new ArrayList<String>(res);
    }
}
