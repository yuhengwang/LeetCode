/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public int val;
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, target, res);
        return res;
    }
    public void dfs(ParentTreeNode root, int target, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        List<Integer> current = new ArrayList<>();
        findSum(root, null, target, current, res);
        dfs(root.left, target, res);
        dfs(root.right, target, res);
    }
    public void findSum(ParentTreeNode root, ParentTreeNode parent, int target, 
    List<Integer> current, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        target = target - root.val;
        current.add(root.val);
        if (target == 0) {
            res.add(new ArrayList<Integer>(current));
        }
        if (root.parent != null && root.parent != parent) {
            findSum(root.parent, root, target, current, res);
        }
        if (root.left != null && root.left != parent) {
            findSum(root.left, root, target, current, res);
        }
        if (root.right != null && root.right != parent) {
            findSum(root.right, root, target, current, res);
        }
        current.remove(current.size() - 1);
      
    }
}
