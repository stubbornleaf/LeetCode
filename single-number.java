public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int result = 0;
        
        for (int index = 0; index < A.length; index++) {
            // Xor of two same integers is zero.
            result ^= A[index];
        }
        
        return result;
    }
}
