public class Solution {
    public int trap(int[] A) {
        int total = 0, height = 0;
        int[] leftHeight = new int[A.length], rightHeight = new int[A.length];
        
        for (int i = 0; i < A.length; i++) {
            leftHeight[i] = height;
            if (A[i] > height) {
                height = A[i];
            }
        }
        
        height = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            rightHeight[i] = height;
            
            // Only when the left and right most highest bars are both higher than current bar, it can trap water.
            if (leftHeight[i] > A[i] && rightHeight[i] > A[i]) {
                if (leftHeight[i] > rightHeight[i]) {
                    total += rightHeight[i] - A[i];
                } else {
                    total += leftHeight[i] - A[i];
                }
            }
            
            if (A[i] > height) {
                height = A[i];
            }
        }
        
        return total;
    }
}
