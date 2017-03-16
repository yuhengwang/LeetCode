/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> res = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> maps = new HashMap<>();
        for (int i = 0; i < results.length; i++) {
            if (!maps.containsKey(results[i].id)) {
                PriorityQueue<Integer>queue = new PriorityQueue<>(); 
                queue.offer(results[i].score);
                maps.put(results[i].id, queue);
            } else {
                PriorityQueue<Integer> q = maps.get(results[i].id);
                if (q.size() < 5) {
                    q.offer(results[i].score);
                } else if (q.peek() < results[i].score) {
                    q.poll();
                    q.offer(results[i].score);
                }
                maps.put(results[i].id, q);
            }
        }
        for (Integer key : maps.keySet()) {
            PriorityQueue<Integer> queue = maps.get(key);
            double sum = 0;
            while (!queue.isEmpty()) {
                sum += queue.poll();
            }
            sum = sum / 5.0;
            res.put(key, sum);
        }
        return res;
    }
}
