public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int q = nums.length - 1;
                while(k < q) {
                    if(nums[i] + nums[j] + nums[k] + nums[q] == target) {
                        current = new ArrayList<>();
                  //      System.out.println(i +" "+ j +" "+ k +" "+ q);
                        current.add(nums[i]);
                        current.add(nums[j]);
                        current.add(nums[k]);
                        current.add(nums[q]);
                        res.add(current);
                        k++;
                        q--;
                        // remove duplicate
                        while(k < q && nums[k] == nums[k-1]) k++;
                        while(k < q && nums[q] == nums[q+1]) q--;
                    } else if (nums[i] + nums[j] + nums[k] + nums[q] > target) {
                        q--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return res;
    } // -2,-1,0,0,1,2
}
