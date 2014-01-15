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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> results = new ArrayList<Interval>();
        if (intervals.size() == 0) return results;
        
        Interval result;
        
        Collections.sort(intervals, new MyComparator());
        
        result = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (int index = 1; index < intervals.size(); index++) {
            Interval current = intervals.get(index);
            if (current.start <= result.end) {
                if (result.end < current.end) {
                    result.end = current.end;
                }
            } else {
                results.add(result);
                result = new Interval(current.start, current.end);
            }
        }
        results.add(result);
        
        return results;
    }
    
    class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval interval1, Interval interval2) {
            return interval1.start - interval2.start;
        }
    }
}
