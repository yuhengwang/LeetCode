/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int height = getHeight(root);
        //initialize before set in the arraylist
        for (int i = 0; i < height; i++) {
            res.add(cur);
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            cur = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                cur.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                    
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
           // System.out.println(cur);
            //System.out.println(height - 1);
            res.set(height - 1, new ArrayList(cur));
            height--;
            
        }
        return res;
        
    }
    public int getHeight(TreeNode root) {
          if (root == null) {
              return 0;
          }
          int left = getHeight(root.left);
          int right = getHeight(root.right);
          return Math.max(left, right) + 1;
    }
}
