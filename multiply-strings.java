public class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder tmpResult = new StringBuilder();
        HashMap<Integer, String> singles = new HashMap<Integer, String>();
        int i;
        
        for (i = 0; i < num1.length() + num2.length(); i++) {
            tmpResult.append("0");
        }
        
        for (i = num2.length() - 1; i >= 0; i--) {
            int single = num2.charAt(i) - '0';
            String singleResult;
            if (singles.containsKey(single)) {
                singleResult = singles.get(single);
            } else {
                singleResult = generateSingleResult(num1, single);
                singles.put(single, singleResult);
            }
            
            int carry = 0;
            int j = singleResult.length() - 1;
            for (; j >= 0; j--) {
                int a = singleResult.charAt(j) - '0', b = tmpResult.charAt(num1.length() + i - (singleResult.length() - 1 - j)) - '0', c = a + b + carry;
                carry = c / 10;
                tmpResult.setCharAt(num1.length() + i - (singleResult.length() - 1 - j), (char)(c % 10 + '0'));
            }
            
            j = num1.length() + i - singleResult.length();
            while (carry != 0) {
                int a = tmpResult.charAt(j) - '0', b = a + carry;
                carry = b / 10;
                tmpResult.setCharAt(j--, (char)(b % 10 + '0'));
            }
        }
        
        i = 0;
        while (tmpResult.charAt(i) == '0' && i++ < tmpResult.length() - 2);
        
        return tmpResult.substring(i);
    }
    
    private String generateSingleResult(String num, int single) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int a = num.charAt(i) - '0', b = single * a + carry;
            carry = b / 10;
            sb.insert(0, (char)(b % 10 + '0'));
        }
        if (carry != 0) {
            sb.insert(0, (char)(carry + '0'));
        }
        return sb.toString();
    }
}
