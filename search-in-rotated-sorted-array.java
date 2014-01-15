public class Solution {
    public int search(int[] A, int target) {
        if (A.length == 0) return -1;
        
        return search(A, 0, A.length - 1, target);
    }
    
    private int search(int[] A, int left, int right, int target) {
        if (left > right) return -1;
        
        int leftVal = A[left], rightVal = A[right], mid = (left + right) / 2, midVal = A[mid];
        
        if (midVal == target) return mid;
        if ((midVal < target && midVal > leftVal) || (midVal < target && midVal < leftVal && leftVal > target) || (midVal > target && midVal > leftVal && leftVal > target) || left == mid) {
            return search(A, mid + 1, right, target);
        } else {
            return search(A, left, mid - 1, target);
        }
    }
}
