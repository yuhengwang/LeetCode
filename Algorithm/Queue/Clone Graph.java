/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
        nodes = getNode(node);
        //copy points
        for (UndirectedGraphNode n : nodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }
        //copy edges
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode cur = map.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                cur.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    public ArrayList<UndirectedGraphNode> getNode(UndirectedGraphNode node) {
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        set.add(node);
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}
