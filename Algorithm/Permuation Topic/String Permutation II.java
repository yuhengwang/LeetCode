
// Given a String "aab", return all permutations including itself, it uses the method of next permutation, starting from the first permutation,
// when it achieve the last permutation, return null as the loop end signal
public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> res = new ArrayList<>();
        char[] arrays = str.toCharArray();
        Arrays.sort(arrays);
        res.add(String.valueOf(arrays));;
        while ((arrays = nextPermutation(arrays)) != null) {
            res.add(String.valueOf(arrays));
        }
        return res;
    }
    public char[] nextPermutation(char[] nums) {
        int less = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                less = i;
                break;
            }
        }
        if (less == -1) {
            return null;
        }
        int big = -1;
        for (int j = nums.length - 1; j > less; j--) {
            if (nums[j] > nums[less]) {
                char temp = nums[j];
                nums[j] = nums[less];
                nums[less] = temp;
                break;
            }
            
        }
        reverse(nums, less + 1);
        return nums;
    }
    public void reverse(char[] nums, int start) {
        for (int i = start, j = nums.length - 1; i < j; i++, j--) {
            char temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
