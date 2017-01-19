public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        Arrays.sort(nums);
   
        for (int i = 0; i < nums.length - 2; i++) {
            
            int target = 0 - nums[i];
            if(i == 0 || nums[i] > nums[i-1]){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
            if(nums[j] + nums[k] == target) {
                current = new ArrayList<Integer>();
                current.add(nums[i]);
                current.add(nums[j]);
                current.add(nums[k]);
                res.add(new ArrayList<Integer>(current));
                j++;
                k--;
 
                    //handle duplicate here
                    while(j<k && nums[j]==nums[j-1])
                        j++;
                    while(j<k && nums[k]==nums[k+1])
                        k--;
              //  return res;
            } else if (nums[j]+nums[k] < target){
                j++;
            } else {
                k--;
            }
            }
        }
        }
       
        System.out.println("ff");
        return res;
        
    }
}
