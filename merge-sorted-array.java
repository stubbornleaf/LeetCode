public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int index = m + n - 1, indexA = m - 1, indexB = n - 1;
        
        for (; index >= 0; index--) {
            if (indexA >= 0 && indexB >= 0) {
                if (A[indexA] >= B[indexB]) {
                    A[index] = A[indexA--];
                } else {
                    A[index] = B[indexB--];
                }
            } else {
                if (indexB >= 0) {
                    for (; index >= 0; index--) {
                        A[index] = B[index];
                    }
                }
                return;
            }
        }
    }
}
