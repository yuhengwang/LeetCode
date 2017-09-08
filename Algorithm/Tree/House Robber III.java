记忆化搜索
在当前层，只有偷或者不偷，如果这层偷就只能偷孙子层，如果这层不偷就偷儿子层的
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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        return traverse(root, new HashMap<TreeNode, Integer>());
    }
    public int traverse(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null)   return 0;
        if(map.containsKey(root))   return map.get(root);
        //if rob root
        int t = root.val;
        if (root.left != null) {
            t += traverse(root.left.left, map) + traverse(root.left.right, map);
        }
        if (root.right != null) {
            t += traverse(root.right.left, map) + traverse(root.right.right, map);
        }
        //if not rob root
        int val = Math.max(t, traverse(root.left, map) + traverse(root.right, map));
        map.put(root, val);
        return val;
    }
}


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
   public int rob(TreeNode root) {
    int[] res = robSub(root);
    return Math.max(res[0], res[1]);
}

private int[] robSub(TreeNode root) {
    if (root == null) return new int[2];
    
    int [] left = robSub(root.left);
    int [] right = robSub(root.right);
    
    int [] res = new int [2];
    res [0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
    res [1] = root.val + left[0] +right[0];
    
    return res;
    
}
}
