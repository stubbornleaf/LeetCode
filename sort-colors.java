public class Solution {
    public void sortColors(int[] A) {
        int redPosition = 0, bluePosition = A.length - 1;
        
        for (int index = 0; index <= bluePosition && index >= redPosition; ) {
            if (A[index] == 0) {
                int tmp = A[redPosition];
                A[redPosition] = 0;
                A[index] = tmp;
                redPosition++;
                index++;
            } else if (A[index] == 2) {
                int tmp = A[bluePosition];
                A[bluePosition] = 2;
                A[index] = tmp;
                bluePosition--;
            } else {
                index++;
            }
        }
    }
}
