public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        
        int[] result = new int[s.length() + 1];
        result[0] = 1;
        
        for (int i = 0; i < s.length(); i++) {
            int newResult = result[i];
            if (s.charAt(i) == '0') {
                if (i == 0) return 0;
                int tmp = Integer.parseInt(s.substring(i - 1, i + 1));
                if (tmp == 0 || tmp > 26) return 0;
                else newResult = result[i - 1];
            } else {
                if (i > 0) {
                    int tmp = Integer.parseInt(s.substring(i - 1, i + 1));
                    if (tmp <= 26 && tmp > 10) {
                        newResult += result[i - 1];
                    }
                }
            }
            result[i + 1] = newResult;
        }
        
        return result[s.length()];
    }
}
