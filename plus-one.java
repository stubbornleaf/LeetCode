public class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int carry = 1;
        
        for (int index = digits.length - 1; index >= 0; index--) {
            int tmp = digits[index] + carry;
            if (tmp == 10) {
                result.add(0);
                carry = 1;
            } else {
                result.add(tmp);
                carry = 0;
            }
        }
        
        if (carry == 1) result.add(1);
        
        int[] finalResult = new int[result.size()];
        for (int index = 0; index < result.size(); index++) finalResult[index] = result.get(result.size() - index - 1);
        return finalResult;
    }
}
