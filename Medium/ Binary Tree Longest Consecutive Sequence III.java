/**
 * Definition for a multi tree node.
 * public class MultiTreeNode {
 *     int val;
 *     List<TreeNode> children;
 *     MultiTreeNode(int x) { val = x; }
 * }
 */
public class Solution {
        private class ResultType {
        int max_down;
        int max_up;
        int max_length;
        public ResultType(int down, int up, int length) {
            max_down = down;
            max_up = up;
            max_length = length;
        }
    }
    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        return helper(root).max_length;
    }
    public ResultType helper(MultiTreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }
        int up = 0;
        int down = 0;
        int len = 1;
        for (MultiTreeNode child : root.children) {
            ResultType result = helper(child);
            if (child.val - 1 == root.val) {
                up = Math.max(result.max_up + 1, up);
            }
            if (child.val + 1 == root.val) {
                down = Math.max(result.max_down + 1, down);
            }
            len = Math.max(len, result.max_length);
            
        }
        // previous len is the largest path of root's children
        // compare with the largest path of the root
        len = Math.max(up + down + 1, len);  
        return new ResultType(down, up, len);
       
        
    }
}
