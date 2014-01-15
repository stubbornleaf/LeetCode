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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> results = new ArrayList<Interval>();
        int index;
        
        for (index = 0; index < intervals.size(); index++) {
            Interval current = intervals.get(index);
            if (current.end < newInterval.start) {
                results.add(new Interval(current.start, current.end));
            } else {
                break;
            }
        }
        
        if (index == intervals.size()) {
            results.add(new Interval(newInterval.start, newInterval.end));
        } else {
            Interval result = new Interval(), current = intervals.get(index);
            result.start = newInterval.start < current.start ? newInterval.start : current.start;
            result.end = newInterval.end;
            
            while (index < intervals.size()) {
                current = intervals.get(index);
                if (newInterval.end < current.start) {
                    result.end = newInterval.end;
                    break;
                } else if (newInterval.end <= current.end) {
                    result.end = current.end;
                    index++;
                    break;
                } else {
                    result.end = newInterval.end;
                    index++;
                }
            }
            results.add(result);
            
            for (; index < intervals.size(); index++) {
                current = intervals.get(index);
                results.add(new Interval(current.start, current.end));
            }
        }
        
        return results;
    }
}
