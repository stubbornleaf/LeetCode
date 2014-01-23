public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        int shift = nRows * 2 - 2;
        
        for (int i = 0; i < s.length(); i += shift) {
            sb.append(s.charAt(i));
        }
        
        int innerShift = (nRows - 2) * 2;
        for (int i = 1; i < nRows - 1; i++) {
            for (int j = i; j < s.length(); j += shift) {
                sb.append(s.charAt(j));
                if ((j + innerShift) < s.length()) {
                    sb.append(s.charAt(j + innerShift));
                }
            }
            innerShift -= 2;
        }
        
        for (int i = nRows - 1; i < s.length(); i+= shift) {
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}
