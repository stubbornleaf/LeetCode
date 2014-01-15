public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[] used = new int[num.length];
        ArrayList<Integer> permutation = new ArrayList<Integer>();
        
        findPermute(num, num.length, used, permutation, result);
        
        return result;
    }
    
    private void findPermute(int[] num, int left, int[] used, ArrayList<Integer> permutation, ArrayList<ArrayList<Integer>> result) {
        if (left == 0) {
            result.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for (int index = 0; index < num.length; index++) {
            if (used[index] != 1) {
                used[index] = 1;
                permutation.add(num[index]);
                findPermute(num, left - 1, used, permutation, result);
                permutation.remove(permutation.size() - 1);
                used[index] = 0;
            }
        }
    }
}
