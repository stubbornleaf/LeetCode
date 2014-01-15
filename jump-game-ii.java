public class Solution {
    public int jump(int[] A) {
        if (A.length <= 1) return 0;
        
        int steps = 1, farest = A[0], current = 0;
        
        while (farest < A.length - 1) {
            int tmp = farest, i;
            for (i = current + 1; i <= farest && i < A.length; i++) {
                if (i + A[i] > tmp) tmp = i + A[i];
            }
            if (farest == tmp) return -1;
            farest = tmp;
            current = i - 1;
            steps++;
        }
        
        return steps;
    }
}
