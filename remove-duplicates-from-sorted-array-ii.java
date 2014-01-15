public class Solution {
    public int removeDuplicates(int[] A) {
        int index, currentIndex, dupCount = 0, currentVal;
        
        if (A.length == 0) return 0;
        
        currentIndex = 1;
        currentVal = A[0];
        for (index = 1; index < A.length; index++) {
            if (A[index] == currentVal) {
                if (dupCount == 1) {
                    
                } else {
                    A[currentIndex] = A[index];
                    currentIndex++;
                    dupCount = 1;
                }
            } else {
                A[currentIndex] = A[index];
                currentVal = A[currentIndex];
                currentIndex++;
                dupCount = 0;
            }
        }
        
        return currentIndex;
    }
}
