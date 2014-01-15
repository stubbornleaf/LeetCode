public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Integer[] tmp = new Integer[candidates.length];
        for (int index = 0; index < candidates.length; index++) tmp[index] = candidates[index];
        List<Integer> sortedCandidates = Arrays.asList(tmp);
        Collections.sort(sortedCandidates);
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> combination = new ArrayList<Integer>();
        if (candidates.length != 0) {
            findCombination(sortedCandidates, 0, target, combination, result);
        }
        return result;
    }
    
    private void findCombination(List<Integer> sortedCandidates, int candidateIndex, int target, ArrayList<Integer> combination, ArrayList<ArrayList<Integer>> result) {
        if (candidateIndex == sortedCandidates.size()) return;
        
        int candidate = sortedCandidates.get(candidateIndex);
        
        if (target == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        
        if (candidate > target) {
            return;
        }
        
        combination.add(candidate);
        findCombination(sortedCandidates, candidateIndex, target - candidate, combination, result);
        combination.remove(combination.size() - 1);
        findCombination(sortedCandidates, candidateIndex + 1, target, combination, result);
    }
}
