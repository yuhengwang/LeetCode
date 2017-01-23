public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
     // traverse
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        helper(res,root);
        return res;
        
    }
    public void helper(ArrayList<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
     // divide and conquer
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
     
        //return
        
        // divide
        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);
        if (left != null) {
            res.addAll(left);
        }
        if (right != null) {
            res.addAll(right);
        }
        res.add(root.val);
        return res;
        
    }
   
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
     
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        // non - recursive
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode prev = null;
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.empty()) {
            curr = stack.peek(); // only get the value but not remove
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {  //leaf node or right child back to parent node
                res.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return res;
        
    }
   
}
