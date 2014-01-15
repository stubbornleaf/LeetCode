public class Solution {
    public int removeDuplicates(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int index = 1, currentLength = 1, length = A.length, previous;
        
        if (length == 0) return 0;
        
        previous = A[0];
        while (index < length) {
            if (A[index] != previous) {
                A[currentLength] = A[index];
                currentLength++;
                previous = A[index];
            }
            index++;
        }
        
        return currentLength;
    }
}
