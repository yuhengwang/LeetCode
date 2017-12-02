class Solution {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int i : nums) {
            temp ^= i;
        }
        //find the first bit where this two numbers are different
        temp &= -temp;
        int[] res = {0, 0};
        for (int num : nums) {
            if ((num & temp) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
