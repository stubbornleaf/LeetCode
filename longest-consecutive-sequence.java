public class Solution {
    public int longestConsecutive(int[] num) {
        int longest = 0;
        HashSet<Integer> set = new HashSet<>(), checked = new HashSet<>();
        
        for (int i = 0; i < num.length; i++) {
            set.add(new Integer(num[i]));
        }
        
        for (Integer i : set) {
            if (!checked.contains(i)) {
                int tmp = 1;
                for (int j = i + 1; ;j++, tmp++) {
                    if (!set.contains(new Integer(j))) {
                        break;
                    }
                    checked.add(new Integer(j));
                }
                for (int j = i - 1; ;j--, tmp++) {
                    if (!set.contains(new Integer(j))) {
                        break;
                    }
                    checked.add(new Integer(j));
                }
                if (tmp > longest) {
                    longest = tmp;
                }
            }
        }
        
        return longest;
    }
}
