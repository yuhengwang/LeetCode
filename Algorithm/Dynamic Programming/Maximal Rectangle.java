//DP, we have 3 DP array, while height[i][j] is to record the height of jth column, left[i][j] is consider the height of height[i][j], its
//leftmost boundary, and right[i][j] is consider the height of height[i][j], its rightmost boundary
// after traversing each row, we calculate the area as (right - left)*height
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];        Arrays.fill(right, n);
        int max = 0;
        for (int i = 0; i < m; i++) {
            int cur_right = n; 
            int cur_left = 0;
           
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(cur_left, left[j]);
                } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(cur_right, right[j]);
                }
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            for (int j = 0; j < n; j++) {
                max = Math.max(max, (right[j] - left[j]) * height[j]);
            }
        }
        return max;
        
    }
} 

// change the question to the maximal rectange in histogram, for each row, we made a histogram as the height array, and get the maximal 
area, and update the global max area
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n + 1];
        height[n] = 0;
        int max = 0;
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < n + 1; j++) {
                if (j < n) {
                    if (matrix[i][j] == '1') {
                        height[j]++;
                    } else {
                        height[j] = 0;
                    }
                }
                if (stack.isEmpty() || height[stack.peek()] <= height[j]) {
                    stack.push(j);
                } else {
                    while (!stack.isEmpty() && height[stack.peek()] > height[j]) {
                        max = Math.max(max, height[stack.pop()] * (stack.isEmpty() ? j : j - stack.peek() - 1));
                    }
                    stack.push(j);
                }
                     
            }
        
        return max;
    }
}

