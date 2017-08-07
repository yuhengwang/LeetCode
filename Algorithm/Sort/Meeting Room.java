不能开会的条件，两个会的开始时间一样，第一个会的结束时间比第二个会的结束时间晚，第一个会的结束时间比第二个开始时间晚
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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a1, Interval a2) {
                if (a1.start == a2.start) {
                    return a1.end - a2.end;
                } else {
                    return a1.start - a2.start;
                }
            }
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].start == intervals[i + 1].start || intervals[i].end >= intervals[i + 1].end || intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}
