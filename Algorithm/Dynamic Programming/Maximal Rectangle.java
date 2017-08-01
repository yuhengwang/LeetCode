//DP 

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
        }
        return max;
    }
}

