public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        HashSet<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[nums1.length - 1] < nums2[j] || nums2[nums2.length - 1] < nums1[i]) {
                break;
            }
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int a : set) {
            res[index] = a;
            index++;
        }
        return res;
    }
}
// binary search
public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
   public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        Arrays.sort(nums1);
        // make the number in nums2 as the target and do the classic binary search
         HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                continue;
            }
            if (binarysearch(nums1, nums2[i])) {
                set.add(nums2[i]);
            }
        
         }
        int[] res = new int[set.size()];
        int index = 0;
        for (Integer a : set) {
            res[index++] = a;
            
        }
        return res;
    }
    private boolean binarysearch(int[] nums1, int target) {
        int start = 0;
        int end = nums1.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums1[mid] == target) {
                return true;
            } else if (nums1[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums1[start] == target) {
            return true;
        }
        if (nums1[end] == target) {
            return true;
        }
        return false;
    }
  
      
}
