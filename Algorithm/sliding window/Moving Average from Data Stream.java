in this method, space complexity would be O(1)

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
    //if the window is not full, window[insert] will always be zero.
    //if the window is full now
    // 2 3 4 5, insert = 0, sum = 14, incoming num = 6
    // 6 3 4 5, insert = 1, sum = 18, incoming num = 7
    // 6 7 4 5....
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
