Given a permutation sequence, find the previous permutation
//step 1: from right to left, find the first num that is LARGER than its right, noted as index1
step2: from right to left, find the first num that is SMALLER than nums[index1], noted as index2
step3: swap index1 and index2
step4: reverse the order of the array from index1 + 1
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		if (nums == null || nums.size() == 0) {
		    return new ArrayList<Integer>();
		}
		if (nums.size() < 2) {
		    return nums;
		}
		int index = -1;
		//scan from right to left and find the first num that is larger than the right side
		for (int i = nums.size() - 2; i >=0 ;i--) {
		    if (nums.get(i) > nums.get(i + 1)) {
		        index = i;
		        break;
		    }
		}
		if (index == -1) {
		    Collections.reverse(nums);
		    return nums;
		}
		int index2 = -1;
		// scan from right to left and find the first num that is smaller than nums[index]
		for (int i = nums.size() - 1; i > index; i--) {
		    if (nums.get(i) < nums.get(index)) {
		        index2 = i;
		        break;
		    }
		}
		swap(nums, index, index2);
		reverse(nums, index);
		return nums;
		
    }
    private void swap(ArrayList<Integer> nums, int index, int index2) {
        int temp = nums.get(index);
        nums.set(index, nums.get(index2));
        nums.set(index2, temp);
    }
    private void reverse (ArrayList<Integer> nums, int index) {
        ArrayList<Integer> reversed = new ArrayList<>();
        for (int i = index + 1;i < nums.size(); i++) {
            reversed.add(nums.get(i));
        }
        int q  = reversed.size() - 1;
        while (q >= 0) {
            nums.set(index++ + 1, reversed.get(q--));
        }
    }
}
