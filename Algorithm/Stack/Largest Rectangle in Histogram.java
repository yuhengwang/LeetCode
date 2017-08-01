// using stack, from the leftmost histogram, we keep push the index until we find the current height is smaller than the last pushed index's height,
we will start to calculate the area covered by last indice stored in the stack. we push - 1 into stack to indicate the end of stack.
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        //store the index
        Stack<Integer> stack = new Stack();
        stack.push(-1); //we only store index in the stack
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
                // for example, the array height is 1, 6, 7, 2.. when we see 2 which is smaller than 7, we start to calculate area
                // first: 7 x 1; second: 6 x 2, and we found 1 is smaller than 2, break this loop
            }
            stack.push(i);
        }
        //reach the end of array
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
            // in the end, the stack only has (corresponding height) 1, 2, 3, when we will pop each element
            // first: 3 x 1, second : 2 x 2, third, 1 * 3, something like it, the width depend on the real index
        }
        return max;
    }
}
