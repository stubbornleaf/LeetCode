public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> combination = new ArrayList<Integer>();
        for (int index = 0; index < k; index++) combination.add(0);
        findCombination(k, n, k, 1, combination, result);
        return result;
    }
    
    private void findCombination(int left, int n, int k, int start, ArrayList<Integer> combination, ArrayList<ArrayList<Integer>> result) {
        if (left == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        
        if (left > (n - start + 1)) return;
        
        findCombination(left, n, k, start + 1, combination, result);
        combination.set(k - left, start);
        findCombination(left - 1, n, k, start + 1, combination, result);
    }
}
