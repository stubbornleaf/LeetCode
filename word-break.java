public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (!result[i]) continue;
            
            for (String word : dict) {
                if ((s.length() - i) >= word.length()) {
                    if (s.substring(i, word.length() + i).equals(word)) {
                        result[i + word.length()] = true;
                    }
                } else {
                    continue;
                }
            }
        }
        
        return result[s.length()];
    }
}
