public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        TreeNode current = root;
        stack.push(root);
        while (!stack.empty()){
            current = stack.pop();
            res.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return res;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // divide and conquer
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        res.add(root.val);
     
        ArrayList<Integer>left = preorderTraversal(root.left);
        ArrayList<Integer>right = preorderTraversal(root.right);
        res.addAll(left);
        res.addAll(right);
        return res;
      
    }
}
