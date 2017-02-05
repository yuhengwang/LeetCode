/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        if (values.get(node) == target) {
            return node;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            ArrayList<UndirectedGraphNode> neighbors = current.neighbors;
            for (UndirectedGraphNode nod : neighbors) {
                if (values.get(nod) == target) {
                     return nod;
                } else {
                    queue.offer(nod);
                }
            }
        }
        return null;
    }
}
