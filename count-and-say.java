public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            
            char previous = result.charAt(0), current;
            int index = 1, count = 1;
            while (index < result.length()) {
                current = result.charAt(index);
                if (previous == current) {
                    count++;
                } else {
                    sb.append(new Integer(count).toString());
                    sb.append(new Character(previous).toString());
                    
                    previous = current;
                    count = 1;
                }
                index++;
            }
            sb.append(new Integer(count).toString());
            sb.append(new Character(previous).toString());
            
            result = sb.toString();
        }
        
        return result;
    }
}
