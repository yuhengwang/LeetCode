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
