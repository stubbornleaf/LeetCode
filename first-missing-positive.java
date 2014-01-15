public class Solution {
    public int firstMissingPositive(int[] A) {
        for (int index = 0; index < A.length; index++) {
            if (A[index] <= 0) A[index] = A.length + 1;
        }
        for (int index = 0; index < A.length; index++) {
            if (Math.abs(A[index]) <= A.length && A[index] != 0 && A[Math.abs(A[index]) - 1] > 0) {
                A[Math.abs(A[index]) - 1] *= -1;
            }
        }
        for (int index = 0; index < A.length; index++) {
            if (A[index] > 0) return index + 1;
        }
        return A.length + 1;
    }
}
