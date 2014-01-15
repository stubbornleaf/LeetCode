public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (num.length == 0) {
            return result;
        }
        
        ArrayList<Integer> permutation = new ArrayList<Integer>();
        boolean[] used = new boolean[num.length];
        
        Arrays.sort(num);
        findPermutation(num, used, num.length, result, permutation);
        
        return result;
    }
    
    private void findPermutation(int[] num, boolean[] used, int left, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution) {
        if (left == 0) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(solution);
            result.add(tmp);
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (!used[i]) {
                if (i > 0 && num[i] == num[i - 1] && !used[i - 1]) {
                    continue;
                }
                
                used[i] = true;
                solution.add(num[i]);
                findPermutation(num, used, left - 1, result, solution);
                solution.remove(solution.size() - 1);
                used[i] = false;
            }
        }
    }
}
