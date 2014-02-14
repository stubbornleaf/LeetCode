public class Solution {
    public int removeDuplicates(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (A.length == 0) return 0;
        
        int index = 0, currentLength = 1, previous = A[0];
        while (++index < A.length) {
            if (A[index] != previous) {
                A[currentLength++] = A[index];
                previous = A[index];
            }
        }
        
        return currentLength;
    }
}
