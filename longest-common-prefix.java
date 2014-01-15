public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        String current = strs[0];
        for (int index = 1; index < strs.length; index++) {
            StringBuilder sb = new StringBuilder();
            int newLength = current.length() < strs[index].length() ? current.length() : strs[index].length();
            
            for (int position = 0; position < newLength; position++) {
                if (current.charAt(position) == strs[index].charAt(position)) {
                    sb.append(current.charAt(position));
                } else {
                    break;
                }
            }
            
            if (current.length() > sb.toString().length()) current = sb.toString();
        }
        
        return current;
    }
}
