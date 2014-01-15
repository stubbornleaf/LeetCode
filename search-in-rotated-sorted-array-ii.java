public class Solution {
    public boolean search(int[] A, int target) {
        return find(A, 0, A.length - 1, target);
    }
    
    private boolean find(int[] A, int start, int end, int target) {
        if (start > end) return false;
        
        int mid = (start + end) / 2, leftVal = A[start], midVal = A[mid], rightVal = A[end];
        
        if (leftVal == target || midVal == target || rightVal == target) return true;
        
        while (leftVal == midVal && start < mid) {
            start++;
            leftVal = A[start];
        }
        if (start == mid) return find(A, mid + 1, end, target);
        
        if ((target > midVal && leftVal < midVal) || (target > midVal && leftVal > midVal && leftVal > target) || (target < midVal && leftVal < midVal && leftVal > target)) {
            return find(A, mid + 1, end, target);
        } else {
            return find(A, start, mid - 1, target);
        }
    }
}
