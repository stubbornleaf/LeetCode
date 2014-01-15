public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        subsets.add(new ArrayList<Integer>());
        
        if (S.length == 0) return subsets;
        
        Integer[] num = new Integer[S.length];
        for (int index = 0; index < S.length; index++) num[index] = S[index];
        List<Integer> sortNum = Arrays.asList(num);
        Collections.sort(sortNum);
        
        for (int numIndex = 0; numIndex < sortNum.size(); numIndex++) {
            ArrayList<ArrayList<Integer>> subset = new ArrayList<ArrayList<Integer>>();
            for (int index = 0; index < subsets.size(); index++) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(subsets.get(index));
                tmp.add(sortNum.get(numIndex));
                subset.add(tmp);
            }
            subsets.addAll(subset);
        }
        
        return subsets;
    }
}
