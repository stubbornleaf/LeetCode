public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int longest = 1, start = 0, end = 0;
        HashSet<Character> set = new HashSet<>();
        set.add(new Character(s.charAt(0)));
        
        for (int i = 1; i < s.length(); i++) {
            Character c = new Character(s.charAt(i));
            end++;
            if (set.contains(c)) {
                while (s.charAt(start) != c) {
                    set.remove(new Character(s.charAt(start)));
                    start++;
                }
                start++;
            } else {
                set.add(c);
                if ((end - start + 1) > longest) {
                    longest = end - start + 1;
                }
            }
        }
        
        return longest;
    }
}
