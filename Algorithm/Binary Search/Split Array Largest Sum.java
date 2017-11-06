  valid function logic:
  // here it is actually not from left to right, the order doesn't matter, it is easy to prove:
            // if a + b > t, c + d > t
            // then there is no way to put a + b + c + d in one array, that is to say,
            // it could be a + b + c > t, d > t
            // or a > t, b + c + d > t
            // it doesn't matter, the number of subarrays is still 2, which is equal to a+b>t, and c+d > t
  
  the smallest largest subsum of array is the max element of the array. 
  
            class Solution {
    public int splitArray(int[] nums, int m) {
       //binary search, start is the maximum number of the array, and end is the total sum of the array
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, n);
        }
        long l = max;
        long r = sum;
        while (l + 1 < r) {
            long mid = (r - l) / 2 + l;
            if (valid(mid, nums, m)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (valid(l, nums, m))  return (int)l;
        return (int)r;
    }
    //[7,2,5,10,8]
    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
