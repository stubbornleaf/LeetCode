public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (num.length < 3) return results;
        
        int start, end, sum;
        Arrays.sort(num);
        for (int index = 0; index < num.length - 2; index++) {
            start = index + 1;
            end = num.length - 1;
            while (start < end) {
                sum = num[index] + num[start] + num[end];
                if (sum == 0) {
                    ArrayList<Integer> result = new ArrayList<Integer>();
                    result.add(num[index]);
                    result.add(num[start]);
                    result.add(num[end]);
                    results.add(result);
                }
                
                if (sum < 0) {
                    while (start < end && num[start] == num[start + 1]) start++;
                    start++;
                } else {
                    while (end > start && num[end] == num[end - 1]) end--;
                    end--;
                }
            }
            
            while (index < (num.length - 1) && num[index] == num[index + 1]) index++;
        }
        
        return results;
    }
}
