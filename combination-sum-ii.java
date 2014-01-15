public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();
        boolean[] used = new boolean[num.length];
        
        Arrays.sort(num);
        findSolution(num, 0, target, used, solution, result);
        
        return result;
    }
    
    private void findSolution(int[] num, int current, int target, boolean[] used, ArrayList<Integer> solution, ArrayList<ArrayList<Integer>> result) {
        if (target == 0) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(solution);
            result.add(tmp);
            return;
        }
        
        for (int i = current; i < num.length && num[i] <= target; i++) {
            if (used[i] || (i > 0 && num[i] == num[i - 1] && !used[i - 1])) {
                continue;
            } else {
                used[i] = true;
                solution.add(num[i]);
                findSolution(num, i + 1, target - num[i], used, solution, result);
                solution.remove(solution.size() - 1);
                used[i] = false;
            }
        }
    }
}
