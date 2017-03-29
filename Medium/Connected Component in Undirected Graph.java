/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> connected = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        for (int i = 0; i < nodes.size(); i++) {
            queue.offer(nodes.get(i));
            while (!queue.isEmpty()) {
                UndirectedGraphNode cur = queue.poll();
                if (set.contains(cur.label)) {
                    continue;
                }
                connected.add(cur.label);
                set.add(cur.label);
                for (UndirectedGraphNode n : cur.neighbors) {
                    queue.offer(n);
                    
                }
            }
            if (connected.size() > 0) {
            Collections.sort(connected);
            res.add(new ArrayList(connected));
            }
            connected = new ArrayList<Integer>();
            
        }
        return res;
       
    }
}
