public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        
        String[] regs = new String[]{ "[-|+]?[0-9]+",
                "[-|+]?[0-9]*\\.[0-9]+",
                "[-|+]?[0-9]+\\.[0-9]*",
                "[-|+]?[0-9]+\\.?[0-9]*e[-|+]?[0-9]+",
                "[-|+]?[0-9]*\\.?[0-9]+e[-|+]?[0-9]+"
                };
        
        for (int i = 0; i < regs.length; i++) {
            if (s.matches(regs[i])) {
                return true;
            }
        }
        
        return false;
    }
}
