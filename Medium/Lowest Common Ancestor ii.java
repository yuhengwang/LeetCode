/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here   
        // shun teng mo gua
        ArrayList<ParentTreeNode> pathA = findPath(A);
        ArrayList<ParentTreeNode> pathB = findPath(B);
        int sizeA = pathA.size();
        int sizeB = pathB.size();
        ParentTreeNode lowComAncestor = null;
        while (sizeA > 0 && sizeB > 0) {
            if (pathA.get(sizeA - 1) != pathB.get(sizeB - 1)){
                break;
            }
            lowComAncestor = pathA.get(sizeA - 1);
            sizeA--;
            sizeB--;
            
        }
        return lowComAncestor;
    }
    public ArrayList<ParentTreeNode> findPath(ParentTreeNode A) {
        ArrayList<ParentTreeNode> res = new ArrayList<>();
        while(A != null) {
            res.add(A);
            A = A.parent;
        }
        return res;
    }
}
