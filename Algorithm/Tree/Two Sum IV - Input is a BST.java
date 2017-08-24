
The idea is to use binary search method. For each node, we check if k - node.val exists in this BST.

Time Complexity: O(nlogn), Space Complexity: O(h). h is the height of the tree, which is logn at best case, and n at worst case.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }
    public boolean dfs(TreeNode root, TreeNode cur, int k) {
        if (cur == null)    return false;
        //if we use cur treenode...            //if we use its left son      //if we use its right son
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }
    public boolean search(TreeNode root, TreeNode cur, int sum) {
        if (root == null)   return false;
        // if the root can be used                 //only root right son can be used                  //only root left son can be used
        return (root.val == sum && root != cur) || (root.val < sum && search(root.right, cur, sum)) || (root.val > sum && search(root.left, cur, sum));
    }
}
