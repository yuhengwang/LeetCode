// level order travese application, always return the last one of the same level, bfs
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        bfs(res, root);
        return res;
    }
    public void bfs(List<Integer> res, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
                if (i == size - 1)
                    res.add(cur.val);
            }
        }
    }
    
}
//dfs
//The core idea of this algorithm:

1.Each depth of the tree only select one node.
2.View depth is current size of result list.

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(res, root, 0);
        return res;
    }
    public void dfs(List<Integer> res, TreeNode root, int viewDepth) {
        if (root == null)
            return;
        if (res.size() == viewDepth)
            res.add(root.val);
        dfs(res, root.right, viewDepth + 1);
        dfs(res, root.left, viewDepth + 1);
    }
}
