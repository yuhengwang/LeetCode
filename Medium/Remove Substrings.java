public class Solution {
    /**
     * @param s a string
     * @param dict a set of n substrings
     * @return the minimum length
     */
    int length = Integer.MAX_VALUE;
    public int minLength(String s, Set<String> dict) {
        // Write your code here
        checkDict(s, dict);
        return length;
    
    }
    private void checkDict(String temp, Set<String> dict) {
        HashSet<String> process = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(temp);
        while (!queue.isEmpty()) {
            boolean flag = false;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
            String cur = queue.poll(); 
            for (String a : dict) {
                int index = 0;
                for (int i = 0;i < cur.length() - 1; i+= (index + a.length())){
                    if (cur.substring(i).contains(a)) {
                    // remove the substrs
                        flag = true;
                        index = cur.indexOf(a, i);
                        String newString = cur.substring(0, index) + cur.substring(index + a.length());
                        if (!process.contains(newString)) {
                            queue.offer(newString);
                            process.add(newString);
                        }
                        
                    } else {
                        break;
                    }
                }
            }
            if (cur.length() < length) {
                length = cur.length();
            }
           
            }
             if (flag == false) {
                break;
            }
        }
        
    }
}
