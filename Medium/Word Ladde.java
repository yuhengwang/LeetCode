public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        
        dict.add(start);
        dict.add(end);
        return bfs(start, end, dict);
    }
    private int bfs(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        queue.offer(start);
        int time = 1;
        while (!queue.isEmpty()) {
             
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
              //  System.out.println(cur);
                
                if (cur.equals(end)) {
                    return time;
                }
                List<String> res = expand(cur, dict);
                for (String s: res) {
                    if (set.contains(s)) {
                        continue;
                    }
                    set.add(s);
                    queue.offer(s);
                }
            }
             time++;
           
        }
        return time;
    }
    private List<String> expand(String cur, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < cur.length(); i++) {
            for (char ch = 'a'; ch < 'z'; ch++) {
                String s = cur.substring(0, i) + ch + cur.substring(i + 1);
                if (dict.contains(s) && !s.equals(cur)) {
                    res.add(s);
                }
                
            }    
        }
        return res;
    }
}
