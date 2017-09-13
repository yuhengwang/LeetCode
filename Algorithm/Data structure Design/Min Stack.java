we also use long in case of the integer overflow
we put the difference between the element and the current min to the stack
if we encounter the new min, we will not update the min immediately, but put the different(negative) first, and then update the difference

class MinStack {
    long min = Long.MAX_VALUE;
    Stack<Long> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
    }
    // if min does not change, the element push to the stack should be always positive only when we encounter 
    new min, the element would be negative
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = (long)x;
        } else {
            stack.push((long)x - min);
        }
        if ((long)x < min)    min = (long)x;
    }
    
    public void pop() {
        if (stack.isEmpty())    return;
        long n = stack.pop();
        //the pop element is negative, means we are pop the current min, and we need to update the min value
        if (n < 0)  min = min - n;
    }
    
    public int top() {
        long num = stack.peek();
        if (num > 0) // min is still in the stack
            return (int)(num + min);
        else  //current min is on the top
            return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
