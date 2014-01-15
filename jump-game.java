public class Solution {
    public boolean canJump(int[] A) {
        if (A.length == 0) return true;
        
        int farest = A[0], current = 1;
        while (farest < A.length - 1 && current <= farest) {
            if (current + A[current] > farest) {
                farest = current + A[current];
            }
            current++;
        }
        
        return farest >= A.length - 1;
    }
}
