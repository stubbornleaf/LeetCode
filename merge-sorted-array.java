public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int index = m + n - 1, indexM = m - 1, indexN = n - 1;
        
        for (; index >= 0; index--) {
            if (indexM >= 0 && indexN >= 0) {
                if (A[indexM] >= B[indexN]) {
                    A[index] = A[indexM--];
                } else {
                    A[index] = B[indexN--];
                }
            } else {
                if (indexN >= 0) {
                    for (; index >= 0; index--) {
                        A[index] = B[index];
                    }
                }
                return;
            }
        }
    }
}
