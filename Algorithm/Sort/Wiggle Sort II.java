
Assume your original array is {6,13,5,4,5,2}. After you get median element, the 'nums' is partially sorted such that the first half is larger or equal to the median, the second half is smaller or equal to the median, i.e
13   6   5   5   4   2

         M


In the post https://leetcode.com/discuss/76965/3-lines-python-with-explanation-proof, we have learned that , to get wiggle sort, you want to put the number in the following way such that

(1) elements smaller than the 'median' are put into the last even slots

(2) elements larger than the 'median' are put into the first odd slots

(3) the medians are put into the remaining slots.
Index :       0   1   2   3   4   5
Small half:   M       S       S    
Large half:       L       L       M


M - Median, S-Small, L-Large. In this example, we want to put {13, 6, 5} in index 1,3,5 and {5,4,2} in index {0,2,4}

The index mapping, (1 + 2*index) % (n | 1) combined with 'Color sort', will do the job.

After selecting the median element, which is 5 in this example, we continue as the following
Mapped_idx[Left] denotes the position where the next smaller-than median element  will be inserted.
Mapped_idx[Right] denotes the position where the next larger-than median element  will be inserted.


Step 1: 
Original idx: 0    1    2    3    4    5  
Mapped idx:   1    3    5    0    2    4 
Array:        13   6    5    5    4    2 
             Left
              i
                                      Right
 nums[Mapped_idx[i]] = nums[1] = 6 > 5, so it is ok to put 6 in the first odd index 1. We increment i and left.


Step 2: 
Original idx: 0    1    2    3    4    5  
Mapped idx:   1    3    5    0    2    4 
Array:        13   6    5    5    4    2 
                  Left
                   i
                                      Right
 nums[3] = 5 = 5, so it is ok to put 6 in the index 3. We increment i.


Step 3: 
Original idx: 0    1    2    3    4    5  
Mapped idx:   1    3    5    0    2    4 
Array:        13   6    5    5    4    2 
                  Left
                        i
                                     Right
 nums[5] = 2 < 5, so we want to put it to the last even index 4 (pointed by Right). So, we swap nums[Mapped_idx[i]] with nums[Mapped_idx[Right]], i.e. nums[5] with nums[4], and decrement Right. 




Step 4: 
Original idx: 0    1    2    3    4    5  
Mapped idx:   1    3    5    0    2    4 
Array:        13   6    5    5    2    4 
                  Left
                        i
                               Right
 nums[5] = 4 < 5, so we want to put it to the second last even index 2. So, we swap nums[5] with nums[2], and decrement Right. 




Step 5: 
Original idx: 0    1    2    3    4    5  
Mapped idx:   1    3    5    0    2    4 
Array:        13   6    4    5    2    5 
                  Left
                        i
                            Right
 nums[5] = 5 < 5, it is ok to put it there, we increment i.


Step 6: 
Original idx: 0    1    2    3    4    5  
Mapped idx:   1    3    5    0    2    4 
Array:        13   6    4    5    2    5 
                  Left
                             i
                            Right
 nums[0] = 13 > 5, so, we want to put it to the next odd index which is 3 (pointed by 'Left'). So, we swap nums[0] with nums[3], and increment 'Left' and 'i'.


Step Final: 
Original idx: 0    1    2    3    4    5  
Mapped idx:   1    3    5    0    2    4 
Array:        5    6    4    13   2    5 
                      Left
                                  i
                            Right
i > Right, we get the final wiggle array 5 6 4 13 2 5 !





public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int medium = findKthLargeElement(nums, 0, nums.length - 1, (nums.length + 1) / 2);
        int left = 0;
        int i = 0;
        int right = nums.length - 1;
        int n = nums.length;
        while (i <= right) {
            if (nums[newIndex(i, n)] > medium) {
                swap(nums, newIndex(i++, n), newIndex(left++, n));
            } else if (nums[newIndex(i, n)] < medium) {
                swap(nums, newIndex(i, n), newIndex(right--, n));
            } else {
                i++;
            }
        }
        
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }
    public int findKthLargeElement(int[] nums, int start, int end, int k) {
       
        if (start == end) {
            return nums[start];
        }
        int pivot = nums[(start + end) / 2];
        int i = start;
        int j = end;
        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        //kth is on the left or right
        if (start + k - 1 <= j) {
            return findKthLargeElement(nums, start, j, k);
        }
        if (start + k - 1 >= i) {
            return findKthLargeElement(nums, i, end, k - (i - start));
        }
        return nums[i - 1];
    }
}
