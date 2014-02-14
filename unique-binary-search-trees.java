public class Solution {
    public int numTrees(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n < 1) return 1;
        
        int[] counts = new int[n + 1];
        counts[0] = 1;
        counts[1] = 1;
        
        for (int index = 2; index <= n; index++) {
            int count = 0;
            for (int innerIndex = 0; innerIndex < index; innerIndex++) {
                count += counts[innerIndex] * counts[index - innerIndex - 1];
            }
            counts[index] = count;
        }
        
        return counts[n];
    }
}
