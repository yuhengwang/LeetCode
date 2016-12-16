public class Solution {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if (nums.length==0) return null;
        TreeNode answer = sortedHelper(nums,0,nums.length-1);
        return answer;
        
        
    }
    
    public TreeNode sortedHelper(int [] nums,int low, int high){
        
        if(high<low)
        return null;
        
        int index= (low+high)/2;
        
        TreeNode head = new TreeNode(nums[index]);
        head.left = sortedHelper(nums,low,index-1);
        head.right = sortedHelper(nums,index+1,high);
        
        return head;
        
        
    }
}
