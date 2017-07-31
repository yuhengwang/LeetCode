another application of level order, but the order to offer in the queue changed, we first insert right child, so that the last treenode
pull is the bottonw left tree value
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        //bfs
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.right != null)
                    queue.offer(root.right);
                if (root.left != null)
                    queue.offer(root.left);
            }
        }
        return root.val;
    }
}
