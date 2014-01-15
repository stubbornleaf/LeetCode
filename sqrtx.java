public class Solution {
    public int sqrt(int x) {
        int start = x, end = 1;
        if (x > Math.sqrt(Integer.MAX_VALUE)) {
            start = (int)Math.sqrt(Integer.MAX_VALUE);
        }
        
        while (start >= end) {
            int tmp = ((start + end) / 2) * ((start + end) / 2);
            if (tmp == x) return (start + end) / 2;
            if (tmp > x) start = (start + end) / 2 - 1;
            else end = (start + end) / 2 + 1;
        }
        
        return start;
    }
}
