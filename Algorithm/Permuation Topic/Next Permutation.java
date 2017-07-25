// given a permutation sequence, find next permutation.
step1:
from the right to left, search the first number which is SMALLER than its right element, note as index1
step2:
from the right to left, search the first number which is LARGER than nums[index1], note as index2
step3:
swap index1 and index2
step4:
reverse the array order from index1 + 1
//-------------------------//
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // search the first number which is smaller than its right element
        if (nums.length < 2) {
            return;
        }
        int index1 = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index1 = i;
                break;
            }
        }
        // the last one of the permutation, need to return the ascending order, which is the first permutation
        if (index1 == -1) {
            Arrays.sort(nums);
            return;
        }
        int index2 = -1;
        for (int i = nums.length - 1; i > index1; i--) {
            if (nums[i] > nums[index1]) {
                index2 = i;
                break;
            }
        }
        //swap index1 and index2
        swap(nums, index1, index2);
        //reverse the order of the array after index
        reverse(nums, index1);
       
    }
    public void swap(int[] nums, int index1, int index2) {
        int t = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = t;
    }
    public void reverse(int[] nums, int index1) {
        int[] reversed = new int[nums.length - index1 - 1];
        for (int i = 0; i < nums.length - index1 - 1; i++) {
            reversed[i] = nums[nums.length - 1 - i];
        }
        //replace with the reversed one
        int p = 0;
        for (int i = index1 + 1; i < nums.length; i++) {
            nums[i] = reversed[p++];
        }
    }
}
