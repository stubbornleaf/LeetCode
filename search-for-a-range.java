public class Solution {
    public int[] searchRange(int[] A, int target) {
        return searchRange(A, 0, A.length - 1, target);
    }
    
    private int[] searchRange(int[] A, int left, int right, int target) {
        if (left > right) {
            return new int[]{ -1, -1 };
        }
        
        int mid = (left + right) / 2, midVal = A[mid];
        if (midVal == target) {
            int newLeft = mid, newRight = mid;
            int[] leftRange = searchRange(A, left, mid - 1, target);
            int[] rightRange = searchRange(A, mid + 1, right, target);
            
            if (leftRange[0] != -1) newLeft = leftRange[0];
            if (rightRange[1] != -1) newRight = rightRange[1];
            
            return new int[]{ newLeft, newRight };
        } else if (midVal > target) {
            return searchRange(A, left, mid - 1, target);
        } else {
            return searchRange(A, mid + 1, right, target);
        }
    }
}
