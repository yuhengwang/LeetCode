/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */

    class UnionFind {
        HashMap<Integer, Integer> father = new HashMap<>();
        UnionFind(HashSet<Integer> set) {
            for (Integer i : set) {
                father.put(i, i);
            }
        }
        public int find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
        }
         
        public int compressedFind(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            int temp = -1;
            int fa = father.get(x);
            if (fa != father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }
            return parent;
        }
        public void union(int x, int y) {
            int f_x = find(x);
            int f_y = find(y);
            if (f_x != f_y) {
                father.put(f_x, f_y);
            }
        }
    }
    

    public List<List<Integer>> print(HashSet<Integer> set, UnionFind uf) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i : set) {
            int fa = uf.find(i);
            if (!map.containsKey(fa)) {
                map.put(fa, new ArrayList<Integer>());
            }
            map.get(fa).add(i);
        }
        for (List<Integer> value : map.values()) {
            if (value.size() > 0) {
                Collections.sort(value);
            }
            ans.add(new ArrayList(value));
        }
        return ans;
    }
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        HashSet<Integer> set = new HashSet<>();
        for (DirectedGraphNode node : nodes) {
            set.add(node.label);
            for (DirectedGraphNode neighbor : node.neighbors) {
                set.add(neighbor.label);
            }
        }
        UnionFind uf = new UnionFind(set);
        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                int fa = uf.find(node.label);
                int fb = uf.find(neighbor.label);
                if (fa != fb) {
                    uf.union(neighbor.label, node.label);
                }
            }
        }
        return print(set, uf);
        
    }
}
