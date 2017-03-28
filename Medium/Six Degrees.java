//longer and general one
/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if (s.label == t.label) {
            return 0;
        }
        HashMap<UndirectedGraphNode, List<UndirectedGraphNode>> map = new HashMap<>();
        for (UndirectedGraphNode node : graph) {
            if (node.neighbors == null) {
                if (s.label == node.label || t.label == node.label) {
                    return -1;
                }
                continue;
            }
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (!map.containsKey(node)) {
                    List<UndirectedGraphNode> lists = new ArrayList<>();
                    lists.add(neighbor);
                    map.put(node, lists);
                } else {
                    map.get(node).add(neighbor);
                }
            }
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(s);
        set.add(s);
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            // if (distance > 6) {
            //     return - 1;
            // }
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode temp = queue.poll();
                for (UndirectedGraphNode neighbor : temp.neighbors) {
                    if (neighbor.label == t.label) {
                        return distance;
                    }
                    if (set.contains(neighbor)) {
                        continue;
                    }
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return -1;
        
        
    }
}
// shorter and smarter one
/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if (s.label == t.label) {
            return 0;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashMap<UndirectedGraphNode, Integer> visited = new HashMap<>();
        queue.offer(s);
        visited.put(s, 0);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            int step = visited.get(cur);
            for (int i = 0; i < cur.neighbors.size(); i++) {
                if (visited.containsKey(cur.neighbors.get(i))) {
                    continue;
                }
                if (cur.neighbors.get(i).label == t.label) {
                    return step + 1;
                }
                visited.put(cur.neighbors.get(i), step + 1);
                queue.offer(cur.neighbors.get(i));
                
            }
        }
        return -1;
        
        
    }
}
