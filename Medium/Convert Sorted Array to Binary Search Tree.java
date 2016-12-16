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


// iterative
public class Solution {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if (nums.length==0) return null;
       
        Stack <TreeNode> stack = new Stack <TreeNode> ();
        Stack <Integer> leftIndex= new Stack <Integer> ();
        Stack <Integer> rightIndex = new Stack <Integer> ();
        
        
        TreeNode first = new TreeNode(0);
        stack.push(first);
        leftIndex.push(0);
        rightIndex.push(nums.length-1);
        
        while(!stack.isEmpty()) {
            
            //low half of the array
            TreeNode current = stack.pop();
            int left = leftIndex.pop();
            int right = rightIndex.pop();
            
            int index=  left + (right-left)/2;
            
            System.out.println(index);
            
            current.val = nums[index];
            
            if(index-1>=left){
                
                current.left = new TreeNode(0);
                stack.push(current.left);
                leftIndex.push(left);
                rightIndex.push(index-1);
                
                
            }
            
            
            if(right>=index+1) {
                
                current.right = new TreeNode(0);
                stack.push(current.right);
                leftIndex.push(index+1);
                rightIndex.push(right);
                
            }
            
            
            
            
            
            
            
            
        }
      
      
      return first;
        
        
    }
    
  
}
