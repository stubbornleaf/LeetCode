public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, index, start = 0, leftInCar = 0;
        int[] leftGas = new int[n];
        
        for (index = 0; index < n; index++) leftGas[index] = gas[index] - cost[index];
        
        if (n == 1) {
            if (leftGas[0] >= 0) return 0;
            else return -1;
        }
        
        start = 0;
        index = 0;
        while (start < n) {
            if (index == (start - 1) % n && (leftInCar + leftGas[index]) >= 0) return start;
            
            leftInCar += leftGas[index];
            if (leftInCar < 0) {
                while (start < n && leftGas[start] >= 0) start++;
                while (start < n && leftGas[start] < 0) start++;
                index = start;
                leftInCar = 0;
            } else {
                index = (index + 1) % n;
            }
        }
        
        return -1;
    }
}
