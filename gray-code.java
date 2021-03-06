public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        int count = 1, currentCode = 0;
        int[] existed;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (n < 0) return result;
        
        for (int index = 0; index < n; index++) {
            count *= 2;
        }
        existed = new int[count];
        existed[0] = 1;
        result.add(0);
        
        for (int index = 1; index < count; index++) {
            for (int bitIndex = 0; bitIndex < n; bitIndex++) {
                int tmp = currentCode, bitOnly = currentCode;
                
                // Only flip one bit to check if it already exists or not.
                bitOnly >>= bitIndex;
                bitOnly &= 1;
                if (bitOnly == 0) {
                    bitOnly = 1;
                    bitOnly <<= bitIndex;
                    tmp += bitOnly;
                } else {
                    bitOnly <<= bitIndex;
                    tmp -= bitOnly;
                }
                
                if (existed[tmp] == 0) {
                    result.add(tmp);
                    existed[tmp] = 1;
                    currentCode = tmp;
                    break;
                }
            }
        }
        
        return result;
    }
}
