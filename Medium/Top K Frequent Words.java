public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    class WordPad {
        int times;
        String word;
        public WordPad(String word, int times) {
            this.word = word;
            this.times = times;
        }
    }
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if (words == null || words.length == 0 || k <= 0) {
            return new String[]{};
        }
        HashMap<String, WordPad> maps = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            if (!maps.containsKey(current)) {
                WordPad pad = new WordPad(current, 1);
                maps.put(current, pad);
            } else {
                WordPad pre = maps.get(current);
                pre.times++;
                maps.put(current, pre);
            }
        }
        PriorityQueue<WordPad> queue = new PriorityQueue<>(k, new Comparator<WordPad> () {
            public int compare(WordPad p1, WordPad p2) {
                if (p2.times != p1.times)
                    return p2.times - p1.times;
                else
                    return p1.word.compareTo(p2.word);
            }
        });
        for (WordPad w: maps.values()) {
            queue.offer(w);
        }
        String[] result = new String[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().word;
        }
        return result;
        
    }
}
