In the last approach, at each step, we update the pointer corresponding to the current minimum element and
traverse over the whole nextnext array to determine the new maximum and minimum values. We can do some optimization
here, by making use of a simple observation.

Whenever we update a single entry of nextnext to consider the new maximum and minimum values(if we already know
the last maximum and minimum values), all the elements to be considered for finding the maximum and minimum values
remain the same except the new element being pointed by a single updated entry in nextnext. This new entry is certainly
larger than the last minimum value(since that was the reasoning behind the updation).

Thus, we can't be sure whether this is the new minimum element or not. But, since it is larger than the last value
being considered, it could be a potential competitor for the new maximum value. Thus, we can directly compare it with 
the last maximum value to determine the current maximum value.

Now, we're left with finding the minimum value iteratively at every step. To avoid this iterative process, a better
idea is to make use of a Min-Heap, which stores the values being pointed currently by the nextnext array. Thus, the
minimum value always lies at the top of this heap, and we need not do the iterative search process.

At every step, we remove the minimum element from this heap and find out the range formed by the current maximum and
minimum values, and compare it with the minimum range found so far to determine the required minimum range. We also
update the increment the index in nextnext corresponding to the list containing this minimum entry and add this element 
to the heap as well.

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) {
            return new int[]{};
        }
        int minX = 0, minY = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE; //candidate pair max value
        int[] next = new int[nums.size()];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums.get(a).get(next[a]) - nums.get(b).get(next[b]));
        //pq get the minimum value
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(i);
            max = Math.max(max, nums.get(i).get(next[i]));
        }
        boolean flag = true;//if found the answer or no way to go far, became false
        for (int i = 0; i < nums.size() && flag; i++) {
            for (int j = 0; j < nums.get(i).size() && flag; j++) {
                int min_i = pq.poll();
                if (minY - minX > max - nums.get(min_i).get(next[min_i])) {
                    minY = max;
                    minX = nums.get(min_i).get(next[min_i]);
                }
                //
                next[min_i]++;
                if (next[min_i] >= nums.get(min_i).size()) {
                    flag = false;
                    break;
                }
                //update the max, because next[min_i] is move to next one
                max = Math.max(max, nums.get(min_i).get(next[min_i]));
                pq.offer(min_i);
            }
        }
        return new int[]{minX, minY};
    }
}
