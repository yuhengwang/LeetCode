LC 211
//HashMap method
public class WordDictionary {
    HashMap<Integer, List<String>> map;
    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new HashMap<Integer, List<String>>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int length = word.length();
        if (!map.containsKey(length)) {
            List<String> list = new ArrayList<>();
            list.add(word);
            map.put(length, list);
        } else {
            map.get(length).add(word);
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
       int length = word.length();
       if (!map.containsKey(length)) {
           return false;
       }
       List<String> dictionary = map.get(length);
       for (String s : dictionary) {
           if (isSame(word, s)) {
               return true;
           }
       }
       return false;
       
    }
    public boolean isSame(String pattern, String dict) {
        if (pattern.length() != dict.length()) {
            return false;
        }
        int length = pattern.length();
        for (int i = 0; i < length; i++) {
            if (pattern.charAt(i) != '.' && pattern.charAt(i) != dict.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

//Trie Method
class TrieNode {
    TrieNode [] children;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}
public class WordDictionary {
    TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    public boolean dfs(String word, int index, TrieNode root) {
        if (index == word.length()){
            return root.isWord;
        }
        if (word.charAt(index) == '.') {
            for (TrieNode child : root.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else if (root.children[word.charAt(index) - 'a'] != null) {
            return dfs(word, index + 1, root.children[word.charAt(index) - 'a']);
        } else {
            return false;
        }
       
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
