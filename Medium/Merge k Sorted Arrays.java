public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        if (arrays == null || arrays.length == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                queue.offer(arrays[i][j]);
            }
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
}
// divide and conquer
public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        if (arrays == null || arrays.length == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        result = mergeArray(arrays, 0, arrays.length - 1);
        return result;
    }
    private List<Integer> mergeArray(int[][] arrays, int start, int end) {
        if (start == end) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < arrays[start].length; i++) {
                res.add(arrays[start][i]);
            }
            return res;
        }
        int mid = (end - start) / 2 + start;
        List<Integer> left = mergeArray(arrays, start, mid);
        List<Integer> right = mergeArray(arrays, mid + 1, end);
        return merge(left, right);
        
    }
    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        return result;
    }
}
