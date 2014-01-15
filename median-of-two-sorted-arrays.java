public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if ((A.length + B.length) % 2 == 0) {
            return ((double)findInSortedArrays((A.length + B.length) / 2, A, 0, A.length - 1, B, 0, B.length - 1) + (double)findInSortedArrays(((A.length + B.length) / 2) + 1, A, 0, A.length - 1, B, 0, B.length - 1)) / 2;
        } else {
            return findInSortedArrays((A.length + B.length + 1) / 2, A, 0, A.length - 1, B, 0, B.length - 1);
        }
    }
    
    private int findInSortedArrays(int k, int A[], int startA, int endA, int B[], int startB, int endB) {
        int midA = (startA + endA) / 2, midB = (startB + endB) / 2;
        
        if (endA < startA) return B[startB + k - 1];
        if (endB < startB) return A[startA + k - 1];
        if (A[midA] == B[midB] && (k == (midA + midB - startA - startB + 1) || k == (midA + midB - startA - startB + 2))) {
            return A[midA];
        }
        
        if (A[midA] >= B[midB]) {
            if ((midA + midB + 2 - startA - startB) > k) {
                return findInSortedArrays(k, A, startA, midA - 1, B, startB, endB);
            } else {
                return findInSortedArrays(k - midB + startB - 1, A, startA, endA, B, midB + 1, endB);
            }
        } else {
            if ((midA + midB + 2 - startA - startB) > k) {
                return findInSortedArrays(k, A, startA, endA, B, startB, midB - 1);
            } else {
                return findInSortedArrays(k - midA + startA - 1, A, midA + 1, endA, B, startB, endB);
            }
        }
    }
}
