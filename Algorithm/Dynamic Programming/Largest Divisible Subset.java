//lintcode
//it is based on longest increasing consequence. We first sort the array. In addition to find the increaseing consequence, we request that
the number can be divided totally. Because we are not only need to find the size of the maxium divisible subset, we need to have an array
to record the specific element we include in the subset. Hence, we create int[] pre to record the last number index in its largest subset.
so that we can trace back to get the content of the largest divisible subset.
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        //state: largest divisble subset size
        int[] f = new int[nums.length];
        //state: the last number index in its largest subset 
        int[] pre = new int[nums.length];
        //initialization
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            pre[i] = 0;
        }
        //loop
        for (int i = 1; i < nums.length; i++) {
            int temp = 1;
            int p = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (f[j] + 1 > temp) {
                    temp = f[j] + 1;
                    p = j;
                    }
                }
            }
            f[i] = temp;
            pre[i] = p;
        }
     
        //answer
        //first find the max f[i] 's index
        int max = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (f[i] > max) {
                max = f[i];
                index = i;
            }
        }
        int s = f[index];
        List<Integer> ans = new ArrayList<>();
        while (index >= 0 && s >= 1) {
            ans.add(nums[index]);
            index = pre[index];
            s--;
        }
        return ans;
        
        
    }
}
