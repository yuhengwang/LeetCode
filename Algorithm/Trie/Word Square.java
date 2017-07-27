//in TrieNode class, we can add some variable to facilitate and make the program easy, for example,in this question, we need the list
of words who has same prefix, we can add this attribute when we build the trie, simialr technic used in word search. 

Method: when we identify the first word, the second word prefix is decided, when we decide the first and the second word, the prefix
of the third word is decided, hence we use trie.
public class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        List<String> startWith = new ArrayList<>();
    }
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode p = root;
            for (char c : words[i].toCharArray()) {
                int pos = c - 'a';
                if (p.next[pos] == null)
                    p.next[pos] = new TrieNode();
                p = p.next[pos];
                p.startWith.add(words[i]);
            }
        }
        return root;
    }
    public ArrayList<String> getPrefix(String prefix, TrieNode root) {
        TrieNode p = root;
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < prefix.length(); i++) {
            int pos = prefix.charAt(i) - 'a';
            if (p.next[pos] != null) {
                p = p.next[pos];
            } else {
                return null;
            }
        }
        res.addAll(p.startWith);
        return res;
    }
    public void dfs(List<List<String>> res, ArrayList<String> temp, TrieNode root,  int l) {
        if (temp.size() == l) {
            res.add(new ArrayList<String>(temp));
            return;
        }
        //!!!! learn to write simple program
        // index decide the prefix of the next word
        StringBuilder sb = new StringBuilder();
        int t = temp.size();
        for (String s : temp) {
            sb.append(s.charAt(t));
        }
        String prefix = sb.toString();
        //-------------------------------------//
        //System.out.println("prefix:  " + prefix);
        List<String> getWords = getPrefix(prefix, root);
        if (getWords == null) {
            return;
        }
        for (int i = 0; i < getWords.size(); i++) {
            temp.add(getWords.get(i));
            dfs(res, temp, root,l);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        int length = words.length;
        int l = words[0].length();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < words.length; i++) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(words[i]);
            dfs(res, temp, root,  l);
            temp.remove(temp.size() - 1);
        }
        return res;
    }
}
