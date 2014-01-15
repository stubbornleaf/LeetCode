public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int index = 0, tmp = 0;
        
        for (; index < A.length; index++) {
            tmp ^= A[index];
        }
        
        return tmp;
    }
}
