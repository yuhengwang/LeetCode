
Time complexity : O(n). The whole tree is traversed atmost once. Here, n refers to the number of nodes in the given binary tree.


•Space complexity : O(m). The size of queue or temp can grow upto atmost the maximum number of nodes at any level in the given binary tree. 
    Here, m refers to the maximum mumber of nodes at any level in the input tree.



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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double temp = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                temp += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            res.add(temp / size);
        }
        return res;
    }
}
