选择K个连续的数，可以将他们当成一个Window，binarysearch的是window的左边界。
class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        //window...
        int start = 0;
        int end = arr.size() - k;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (Math.abs(arr.get(mid) - x) > Math.abs(arr.get(mid + k) - x)) {
                start = mid;
            } else{
                end = mid;
            }
        }
        return diff(arr.subList(start, start + k), x) > diff(arr.subList(end, end + k), x) ? arr.subList(end, end + k) : arr.subList(start, start + k); 
    }
    public int diff(List<Integer> l, int x) {
        int d = 0;
        for (int num : l) {
            d += Math.abs(num - x);
        }
        return d;
    }
}
