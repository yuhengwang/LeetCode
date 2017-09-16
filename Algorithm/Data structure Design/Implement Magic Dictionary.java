class MagicDictionary {
    HashSet<String> dictionary = null;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        dictionary = new HashSet<String>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            dictionary.add(s);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        //output the modified word and check whether the set contains it or not
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (word.charAt(i) == c)    continue;
                if (i == 0) {
                    String newWord = c + word.substring(i + 1);
                    if (dictionary.contains(newWord)) {
                        return true;
                    }
                } else {
                    String newWord = word.substring(0, i) + c + word.substring(i + 1);
                    if (dictionary.contains(newWord)) {
                        return true;
                    }
                }
                
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
