/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 recursive
 条件要先判断右边是否为空，因为如果右边为空，我们是不要加括号的。
 左边不管是否为空都需要加括号
class Solution {
    
    public String tree2str(TreeNode t) {
        if (t == null)  return "";
        if (t.left == null && t.right == null) {
            return t.val + "";
        }
        if (t.right == null) {
            return t.val+ "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }
}

In order to solve the given problem, we can also make use of a stackstack. To see how to do it, we'll go through the implementation 
and we'll also look at the idea behind each step.

We make use of a stackstack onto which various nodes of the given tree will be pushed during the process. The node at the top of 
the stackstack represents the current node to be processed. Whenever a node has been processed once, it is marked as visited. The 
reasoning behind this will be discussed soon.

We start off by pushing the root of the binary tree onto the stackstack. Now, the root acts as the current node. For every current 
node encountered, firstly, we check if it has not been visited already. If not, we add it to the set of visited nodes.

Since, for the preorder traversal, we know, we need to process the nodes in the order current-left-right. Thus, we add a ( followed
by the current node to the string ss to be returned.

Now, if both the left and the right children of the current node exist, we need to process them in the order left-right. To do so, 
we need to push them onto the stackstack in the reverse order, so that when they are picked up later on, their order of processing
gets corrected.

Since we've already added (current\_node(current_node to the string ss, if only the right child of the current node exists, as 
discussed in case 4 in the last approach, we need to put a () in ss representing the null left node. We need not push anything
onto the stackstack for the left node and we can directly add the () to ss for this. But, we still need to push the right child 
onto the stackstack for future processing.

If only the left child exists, we need not consider the right child at all, as discussed in case 3 in the last approach. We can
continue the process by just pushing the left child onto the stackstack.

Now, we need to note that even when a node is being processed, if it has not already been visited, it isn't popped off from the 
stackstack. But, if a node that has already been processed(i.e. its children have been considered already), it is popped off from
the stackstack when encountered again. Such a situation will occur for a node only when the preorder traversal of both its left
and right sub-trees has been completely done. Thus, we need to add a ) to mark the end of the preorder traversal of the current
node as well.

Thus, at the end, we get the required pre-order traversal in the substring s(1:n-1)s(1:n−1). Here, nn represents the length of ss.
This is because, we need not put the parentheses(redundant) at the outermost level.


iterative
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
    
    public String tree2str(TreeNode t) {
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        stack.push(t);
        while (!stack.empty()) {
            TreeNode cur = stack.peek();
            if (visited.contains(cur)) {
                sb.append(")");
                stack.pop();
            } else {
                visited.add(cur);
                sb.append("(" + cur.val);
                //if cur.right == null, do nothing
                if (cur.left == null && cur.right != null) {
                    sb.append("()");
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return sb.toString().substring(1, sb.toString().length() - 1);
    }
}

