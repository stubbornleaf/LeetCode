public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (num.length < 4) {
            return result;
        }
        
        Arrays.sort(num);
        int previous = num[0] - 1;
        for (int i = 0; i <= num.length - 4; i++) {
            if (num[i] != previous) {
                ArrayList<ArrayList<Integer>> solutions = threeSum(num, i + 1, target - num[i]);
                
                for (ArrayList<Integer> solution : solutions) {
                    solution.add(0, num[i]);
                    result.add(solution);
                }
                
                previous = num[i];
            }
        }
        
        return result;
    }
    
    private ArrayList<ArrayList<Integer>> threeSum(int[] num, int start, int target) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        
        int previous = num[start] - 1;
        for (int i = start; i <= num.length - 3; i++) {
            if (num[i] != previous) {
                int left = i + 1, right = num.length - 1;
                
                while (left < right) {
                    if (num[left] + num[right] == target - num[i]) {
                        ArrayList<Integer> solution = new ArrayList<Integer>();
                        solution.add(num[i]);
                        solution.add(num[left]);
                        solution.add(num[right]);
                        solutions.add(solution);
                        do {
                            left++;
                        } while (num[left] == num[left - 1] && left < right);
                    } else if (num[left] + num[right] < target - num[i]) {
                        left++;
                    } else {
                        right--;
                    }
                }
                
                previous = num[i];
            }
        }
        
        return solutions;
    }
}
