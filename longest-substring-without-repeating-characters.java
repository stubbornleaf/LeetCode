public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Boolean> contained = new HashMap<Character, Boolean>();
        int longest = 0, current = 0;
        
        for (int index = 0; index < s.length(); index++) {
            Character c = s.charAt(index);
            if (contained.containsKey(c) && contained.get(c)) {
                Character head = s.charAt(index - current);
                while (head.compareTo(c) != 0) {
                    contained.put(head, false);
                    current--;
                    head = s.charAt(index - current);
                }
            } else {
                contained.put(c, true);
                current++;
                if (current > longest) longest = current;
            }
        }
        
        return longest;
    }
}
