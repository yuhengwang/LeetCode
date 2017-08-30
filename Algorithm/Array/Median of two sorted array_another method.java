class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if (len % 2 == 1) {
            return findKth(nums1, nums2, 0, 0, len / 2 + 1);
        } else {
            return (findKth(nums1, nums2, 0, 0, len / 2) + findKth(nums1, nums2, 0, 0, len / 2 + 1)) / 2.0;
        }
    }
    public double findKth(int[] nums1, int[] nums2, int start1, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        //第k/2个数是多少
        int A_key = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k/2 - 1] : Integer.MAX_VALUE;
        int B_key = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k/2 - 1] : Integer.MAX_VALUE;
        //从第k/2 + 1个数开始。。，一定要是k - k /2!!!!!!!
        if (A_key < B_key) {
            return findKth(nums1, nums2, start1 + k / 2, start2, k - k / 2);
        } else {
            return findKth(nums1, nums2, start1, start2 + k / 2, k - k / 2);
        }
    }
}
