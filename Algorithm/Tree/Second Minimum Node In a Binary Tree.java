hashset is unordered
linkedhashset can reverse the insertion order
 treeset can order naturally
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
    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        traverse(root, set);
        int count = 1;
        for (Integer n : set) {
            if (count == 2) return n;
            count++;
        }
        return -1;
    }
    public void traverse(TreeNode root, TreeSet<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        traverse(root.left, set);
        traverse(root.right, set);   
    }
}
