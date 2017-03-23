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
