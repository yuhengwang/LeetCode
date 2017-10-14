//O(1) space complexity, comparing to using queue
class MovingAverage {
    int[] window;
    int n;
    int insert;
    long sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        n = 0;
        insert = 0;
        sum = 0;
    }
    
    public double next(int val) {
       if (n < window.length) n++;
       sum -= window[insert];
       sum += val;
       window[insert] = val;
        insert = (insert + 1) % window.length;
        return (double)sum / n;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
