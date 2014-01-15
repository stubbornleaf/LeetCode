public class Solution {
    public int removeElement(int[] A, int elem) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int index = 0, last = A.length - 1;
        
        while (index <= last) {
            if (A[index] == elem) {
                A[index] = A[last];
                last--;
            } else {
                index++;
            }
        }
        
        return last + 1;
    }
}
