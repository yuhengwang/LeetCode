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
// unionFind
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
    class UnionFind {
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        UnionFind(HashSet<Integer> hashSet) {
            for (Integer now : hashSet) {
                father.put(now, now);
            }
        }
        int find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
        }
        int compressed_find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            int next;
            while (x != father.get(x)) {
                next = father.get(x);
                father.put(x, parent);
                x = next;
            }
            return parent;
        }
        void union(int x, int y) {
            int fa_x = find(x);
            int fa_y = find(y);
            if (fa_x != fa_y) {
                father.put(fa_x, fa_y);
            }
        }
    }
    List<List<Integer>> print(HashSet<Integer> hashSet, UnionFind uf) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i : hashSet) {
            int parent = uf.find(i);
            if (!map.containsKey(parent)) {
                map.put(parent, new ArrayList<Integer>());
            }
            map.get(parent).add(i);
        }
        for (List<Integer> value : map.values()) {
            if (value.size() > 0) {
                Collections.sort(value);
            }
            res.add(new ArrayList(value));
        }
        return res;
     
    }
    
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        HashSet<Integer> set = new HashSet<>();
       for (UndirectedGraphNode now : nodes) {
           set.add(now.label);
           for (UndirectedGraphNode neighbor : now.neighbors) {
               set.add(neighbor.label);
           }
       }
       UnionFind uf = new UnionFind(set);
       for (UndirectedGraphNode now : nodes) {
           for (UndirectedGraphNode neighbor : now.neighbors) {
               int f_now = uf.find(now.label);
               int f_neighbor = uf.find(neighbor.label);
               if (f_now != f_neighbor) {
                   uf.union(now.label, neighbor.label);
               }
           }
       }
       return print(set, uf);
        
    }
}
