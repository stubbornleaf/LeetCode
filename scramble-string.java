public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Character c = new Character(s1.charAt(i));
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) + 1);
            } else {
                counts.put(c, 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            Character c = new Character(s2.charAt(i));
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) - 1);
            } else {
                return false;
            }
        }
        
        for (Character c : counts.keySet()) {
            if (counts.get(c) != 0) {
                return false;
            }
        }
        
        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i), s12 = s1.substring(i, s1.length());
            if (isScramble(s11, s2.substring(0, i)) &&
                isScramble(s12, s2.substring(i, s2.length()))) {
                return true;
            }
            if (isScramble(s11, s2.substring(s2.length() - i, s2.length())) &&
                isScramble(s12, s2.substring(0, s1.length() - i))) {
                return true;
            }
        }
        return false;
    }
}
