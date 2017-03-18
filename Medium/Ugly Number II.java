class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        Long[] prime = new Long[3];
        prime[0] = Long.valueOf(2);
        prime[1] = Long.valueOf(3);
        prime[2] = Long.valueOf(5);
        queue.offer(prime[0]);
        queue.offer(prime[1]);
        queue.offer(prime[2]);
        set.add(prime[0]);
        set.add(prime[1]);
        set.add(prime[2]);
        Long number = Long.valueOf(1);
        for (int i = 1; i < n; i++) { 
            number = queue.poll();
            for (int j = 0; j < 3; j++) {
                if (!set.contains(number * prime[j])) {
                    queue.offer(number * prime[j]);
                    set.add(number * prime[j]);
                }
            }
        }
        return number.intValue();
        
    }
};
