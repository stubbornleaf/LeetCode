public class Solution {
    public String addBinary(String a, String b) {
        int indexA = a.length() - 1, indexB = b.length() - 1, carry = 0, bit = 0;
        StringBuilder sb = new StringBuilder();
        
        for (; indexA >= 0 || indexB >= 0; indexA--, indexB--) {
            if (indexA >= 0) bit += Integer.parseInt(new Character(a.charAt(indexA)).toString());
            if (indexB >= 0) bit += Integer.parseInt(new Character(b.charAt(indexB)).toString());
            bit += carry;
            
            if (bit == 0) {
                sb.insert(0, '0');
                carry = 0;
            } else if (bit == 1) {
                sb.insert(0, '1');
                carry = 0;
            } else if (bit == 2) {
                sb.insert(0, '0');
                carry = 1;
            } else {
                sb.insert(0, '1');
                carry = 1;
            }
            
            bit = 0;
        }
        if (carry == 1) sb.insert(0, '1');
        
        return sb.toString();
    }
}
