想结合same tree的函数，但纠结于找到s的查找起点，想找到t root的值，但其实可以traverse到任何一点来看，只要有true就可以成立
time complexity O(m *n), m, n is the tree depth of TreeNode s, t
space complexity O(n), The depth of the recursion tree can go upto n. n refers to the number of nodes in s.
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
           return traverse(s, t);
    }
    public boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (isSame(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }
    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
