example: Given [14, 11, 7, 2], which in binary are [1110, 1011, 0111, 0010].
Since the MSB is 3, I'll start from i = 3 to make it simplify.

i = 3, set = {1000, 0000}, max = 1000
i = 2, set = {1100, 1000, 0100, 0000}, max = 1100
i = 1, set = {1110, 1010, 0110, 0010}, max = 1100
i = 0, set = {1110, 1011, 0111, 0010}, max = 1100

class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
             HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                mask |= (1 << i);
                set.add(num & mask);
            }
            //
            int temp = max | (1 << i);
       // if set.contains(prefix ^ temp) succeed, it means we can find the right pair to generate ideal maximum, a ^ b = c--> b ^ c = a  
                for (int prefix : set) {
                    if (set.contains(prefix ^ temp)) {
                        max = temp;
                    }
                }
            
        }
        return max;
    
    }
}
