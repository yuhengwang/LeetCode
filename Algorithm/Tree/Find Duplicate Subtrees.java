/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 用string来记录树的路径，postorder.
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        if (root == null) {
            return res;
        }
        dfs(res, root, map);
        return res;
    }
    public String dfs(List<TreeNode> res, TreeNode root, HashMap<String, Integer> map) {
        if (root == null)   return "#";
        String left = dfs(res, root.left, map);
        String right = dfs(res, root.right, map);
        String s = root.val + "," + left + "," + right;
        if (map.getOrDefault(s, 0) == 1)   res.add(root);
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }

}
