public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
        
        for (int index = 0; index < numbers.length; index++) {
            hashTable.put(numbers[index], index);
        }
        
        for (int index = 0; index < numbers.length; index++) {
            if (hashTable.containsKey(target - numbers[index]) && hashTable.get(target - numbers[index]) != index) {
                return new int[]{ index + 1, hashTable.get(target - numbers[index]) + 1 };
            }
        }
        
        return new int[]{ -1, -1 };
    }
}
