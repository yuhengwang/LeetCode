arrays is sorted by start time, and priority queue is sorted by end time, sorting start time decide the order to add in the queue,
end time can determine whether we need to add another meeting room
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a1, Interval a2) {
                    return a1.start - a2.start;
            }
        });
        PriorityQueue<Interval> queue = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
           public int compare(Interval a1, Interval a2) {
               return a1.end - a2.end;
           } 
        });
        queue.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = queue.poll();
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                queue.offer(intervals[i]);
            }
            queue.offer(interval);
        }
        return queue.size();
        
    }
}
