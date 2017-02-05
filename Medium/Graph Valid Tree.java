public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        // n points, n - 1 edges to connect all points
        if (n == 0) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }
        HashMap<Integer, Set<Integer>> map = initializeGraph(n, edges);
        int visit = 0;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> hash = new HashSet<>();
        queue.offer(0);
        hash.add(0);
        while(!queue.isEmpty()) {
            int a = (int)queue.poll();
            visit++;
            for (int neigbors: map.get(a)) {
                if (hash.contains(neigbors)) {
                    continue;
                }
                queue.offer(neigbors);
                hash.add(neigbors);
            }
        }
        return n == visit;
        
    }
    public HashMap<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            map.get(a).add(b);
            map.get(b).add(a);
            
        }
        return map;
    }
}
