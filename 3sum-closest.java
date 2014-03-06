public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3) return 0;
        
        int current = num[0] + num[1] + num[2], start, end, sum;
        Arrays.sort(num);
        for (int index = 0; index < num.length - 2; index++) {
            // Use a fixed num and ajust other two numbers.
            start = index + 1;
            end = num.length - 1;
            while (start < end) {
                sum = num[index] + num[start] + num[end];
                if (sum == target) return target;
                if (Math.abs(sum - target) < Math.abs(current - target)) {
                    current = sum;
                }
                if (sum > target) end--;
                else start++;
            }
        }
        
        return current;
    }
}
