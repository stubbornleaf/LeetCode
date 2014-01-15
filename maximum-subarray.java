public class Solution {
    public int maxSubArray(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int max = Integer.MIN_VALUE, currentSum = 0;
        
        for (int index = 0; index < A.length; index++) {
            if (currentSum + A[index] > 0) {
                if (currentSum < 0) {
                    currentSum = A[index];
                } else {
                    currentSum += A[index];
                }
            }
            else currentSum = A[index];
            
            if (currentSum > max) max = currentSum;
        }
        
        return max;
    }
}
