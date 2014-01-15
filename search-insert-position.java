public class Solution {
    public int searchInsert(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length = A.length, left = 0, right = length - 1, mid, closestBigger = length;
        
        while (left <= right) {
            mid = (left + right) / 2;
            
            if (A[mid] == target) return mid;
            
            if (A[mid] > target) {
                right = mid - 1;
                closestBigger = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return closestBigger;
    }
}
