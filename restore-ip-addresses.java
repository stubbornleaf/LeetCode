public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        findIPAddress(s, 0, 0, sb, result);
        
        return result;
    }
    
    private void findIPAddress(String s, int position, int count, StringBuilder sb, ArrayList<String> result) {
        if (position == s.length() && count == 4) {
            String tmp = sb.toString();
            result.add(tmp.substring(0, tmp.length() - 1));
            return;
        }
        
        if (count >= 4) {
            return;
        }
        
        for (int i = 0; i < 3 && (position + i) < s.length(); i++) {
            String tmp = s.substring(position, position + i + 1);
            Integer val = Integer.valueOf(tmp);
            if ((val < 256 && val >= 100 && i == 2) || (val < 100 && val >=10 && i == 1) || (val < 10 && val >= 0 && i == 0)) {
                sb.append(tmp + ".");
                findIPAddress(s, position + i + 1, count + 1, sb, result);
                sb.delete(sb.length() - i - 2, sb.length());
            }
        }
    }
}
