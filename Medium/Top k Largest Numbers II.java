public class Solution {
    PriorityQueue<Integer> queue;
    int k;

    public Solution(int k) {
        // initialize your data structure here.
        queue = new PriorityQueue<>();
        this.k = k;
    }

    public void add(int num) {
        // Write your code here
        if (queue.size() < k) {
            queue.offer(num);
        } else {
            if (num > queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
         
    }

    public List<Integer> topk() {
        // Write your code here
        Iterator<Integer> iterator = queue.iterator();
        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
};
