public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int one = 0, two = 0, xthree = 0;
        
        for (int index = 0; index < A.length; index++) {
            two |= one & A[index];
            one ^= A[index];
            xthree = ~(one & two);
            one &= xthree;
            two &= xthree;
        }
        
        return one;
    }
}
