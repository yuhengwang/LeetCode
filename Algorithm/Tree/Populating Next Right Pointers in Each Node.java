
//similar to the level order traverse
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode prev = null;
            TreeLinkNode curr = null;
            for (int i = 0; i < size; i++) {
                curr = queue.poll();
                if (prev != null) 
                    prev.next = curr;
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
                prev = curr;
            }
            curr.next = null;
        }
    }
}
