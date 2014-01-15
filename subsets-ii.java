public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        subsets.add(new ArrayList<Integer>());
        
        if (num.length == 0) return subsets;
        
        Integer[] nums = new Integer[num.length];
        for (int index = 0; index < num.length; index++) nums[index] = num[index];
        
        List<Integer> sortNum = Arrays.asList(nums);
        Collections.sort(sortNum);
        
        int previous = sortNum.get(0), current = 0, count = 1;
        for (int keyIndex = 1; keyIndex <= sortNum.size(); keyIndex++) {
            if (keyIndex < sortNum.size()) {
                current = sortNum.get(keyIndex);
            } else {
                current = previous - 1;
            }
            
            if (previous == current) {
                count++;
            } else {
                ArrayList<ArrayList<Integer>> newSet = new ArrayList<ArrayList<Integer>>();
                for (int i = 1; i <= count; i++) {
                    for (int index = 0; index < subsets.size(); index++) {
                        ArrayList<Integer> tmp = new ArrayList<Integer>(subsets.get(index));
                        for (int j = 0; j < i; j++) {
                            tmp.add(previous);
                        }
                        newSet.add(tmp);
                    }
                }
                subsets.addAll(newSet);
                
                previous = current;
                count = 1;
            }
        }
        
        return subsets;
    }
}
