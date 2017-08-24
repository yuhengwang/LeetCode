how many classes we can take ??
class Solution {
    //similar to meeting room
    public int scheduleCourse(int[][] courses) {
        // sort the course schedule according to the end time, ascending
        Arrays.sort(courses,(a, b) -> a[1] - b[1]);
        //if time exceeds, drop the longest time duration course, sort length descending
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int startTime = 0;
        for (int[] course : courses) {
            startTime += course[0];
            queue.offer(course[0]);
            if (startTime > course[1]) {
                startTime -= queue.poll();
            }
                
        }
        return queue.size();
    }
}
