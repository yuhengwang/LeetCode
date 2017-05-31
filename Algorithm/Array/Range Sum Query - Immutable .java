subarray sum method
public class NumArray {    
  int [] sum;    
  public NumArray(int[] nums) {        
    sum = new int[nums.length + 1];        
    sum[0] = 0;        
    for (int i = 1; i < nums.length + 1; i++) {           
      sum[i] = sum[i - 1] + nums[i - 1];         
      //   System.out.println(sum[i]);       
    }    
}      
  public int sumRange(int i, int j) {   
    return sum[j + 1] - sum[i];   
   }
}
