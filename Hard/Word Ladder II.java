public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        List<List<String>> res = new ArrayList<>();
        List<String> current = new ArrayList<>();
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        if (dict == null || dict.size() == 0) {
            return res;
        }
        dict.add(start);
        dict.add(end);
        for (String s: dict) {
            map.put(s, new ArrayList<String>());
        }
        bfs(map, distance, dict, start, end);
    //    System.out.println(distance);
     //   System.out.println(map);
        dfs(res, current, end, start, distance, map);
        return res;
    }
    public void dfs(List<List<String>> res, List<String> path, String crt,
            String start, Map<String, Integer> distance,
            Map<String, List<String>> map) {
                path.add(crt);
          //      System.out.println("path: " + path);
                if (crt.equals(start)) {
                    Collections.reverse(path);
                    res.add(new ArrayList(path));
                    Collections.reverse(path);
                } else {
                    List<String> next = map.get(crt);
             //       System.out.println("next: " + next);
                    for (String s : next) {
                    //    System.out.println("s: " + s);
                        if (distance.containsKey(s) && distance.get(s) == distance.get(crt) - 1) {
                            
                            dfs(res, path, s, start, distance, map);
                    //       System.out.println("s: " + s);
                            path.remove(path.size() - 1);
                        }
                    }
                }
               // path.remove(path.size() - 1); // these two positions are both okay,because the only condition for dfs finish is s is start, and start is the only solution, so it will definitely break the loop when finished. 
        
    }
    public void bfs(Map<String, List<String>> map, Map<String, Integer> distance, Set<String> dict, String start,
                String end) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            List<String> children = expand(curr, dict);
            for (String next : children) {
              map.get(next).add(curr);
              if (!distance.containsKey(next)) {
                  distance.put(next, distance.get(curr) + 1);
                  queue.offer(next);
              }
            }
        }
    }
    public List<String> expand (String curr, Set<String> dict) {
        List<String> res = new ArrayList<>();
         for (int i = 0; i < curr.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (curr.charAt(i) != ch) {
                        String mutatedString = curr.substring(0, i) + ch + curr.substring(i + 1);
                        if (dict.contains(mutatedString)) {
                          res.add(mutatedString);
                        }
                     }
                 }
         }
        // System.out.println(res);
         return res;
    }
}
