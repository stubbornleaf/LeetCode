public class Solution {
    public int atoi(String str) {
        if (str == null) return 0;
        
        int result = 0, start = -1, end = -1;
        boolean hasNum = false, isNeg = false, hasPos = false;
        for (int i = 0; i <  str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                if (hasNum || isNeg || hasPos) break;
                else continue;
            } else if (c < '0' || c > '9') {
                if (c == '-') {
                    if (hasNum || hasPos || isNeg) break;
                    else isNeg = true;
                } else if (c == '+') {
                    if (hasNum || hasPos || isNeg) break;
                    else hasPos = true;
                } else {
                    break;
                }
            } else {
                if (!hasNum) {
                    hasNum = true;
                }
                if (start == -1 && c != '0') {
                    start = i;
                }
                end = i;
                
                result *= 10;
                result += c - '0';
                if (start != -1 && !new Integer(result).toString().equals(str.subSequence(start, end + 1))) {
                    if (isNeg) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            }
        }
        
        if (!hasNum) return 0;
        return isNeg ? result * -1 : result;
    }
}
