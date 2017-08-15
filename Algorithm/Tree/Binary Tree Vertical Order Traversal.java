BFS + queue, one is to store the treenode, one is to store the column, for left children column - 1, for right children col + 1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        node.offer(root);
        queue.offer(0);
        int min = 0;
        int max = 0;
        while (!node.isEmpty()) {
            TreeNode cur = node.poll();
            int col = queue.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            } 
            map.get(col).add(cur.val);
            if (cur.left != null) {
                node.offer(cur.left);
                queue.offer(col - 1);
                min = Math.min(col - 1, min);
            }
            if (cur.right != null) {
                node.offer(cur.right);
                queue.offer(col + 1);
                max = Math.max(col + 1, max);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
