public class Solution {
    public int numTrees(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n <= 1) return 1;
        
        int[] counts = new int[n + 1];
        int index = 2, count;
        counts[0] = 1;
        counts[1] = 1;
        
        for (; index <= n; index++) {
            int innerIndex = 0;
            count = 0;
            for (; innerIndex < index; innerIndex++) {
                count += counts[innerIndex] * counts[index - innerIndex - 1];
            }
            counts[index] = count;
        }
        
        return counts[n];
    }
}
