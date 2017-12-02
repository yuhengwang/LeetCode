class Solution {
    public int findDuplicate(int[] nums) {
        //binary search
        int start = 1;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            int count = 0;
            for (int n : nums) {
                if (n <= mid)
                    count++;
            }
            if (count <= mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int c = 0;
        for (int n : nums) {
            if (n == start)
                c++;
        }
        if (c > 1)  return start;
        return end;
    }
}
