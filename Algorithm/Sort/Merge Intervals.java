First, we get the earliest start time, and its corresponding end time as the bar, and we compare it to next interval, if they can combine,
then combine, until they cannot, and int start, int end keep updated.
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new LinkedList();
        }
        Collections.sort(intervals, (a, b)-> a.start - b.start);
        List<Interval> res = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                //merge together
                end = Math.max(end, interval.end); 
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
        
    }
}
