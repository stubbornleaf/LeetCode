public class Solution {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
        HashMap<Character, Integer> expected = new HashMap<Character, Integer>();
        int start = 0, end = 0, min = S.length() + 1, count = 0;
        String minString = "";
        
        for (char c : T.toCharArray()) {
            if (expected.containsKey(c)) {
                expected.put(c, expected.get(c) + 1);
            } else {
                expected.put(c, 1);
            }
        }
        
        for (int i = 0; i < S.length(); i ++) {
            if (expected.containsKey(S.charAt(i))) {
                start = i;
                end = i;
                count = 1;
                counts.put(S.charAt(i), 1);
                break;
            }
        }
        
        while (end < S.length()) {
            if (count == T.length()) {
                if (min > end - start + 1) {
                    min = end - start + 1;
                    minString = S.substring(start, end + 1);
                }
                
                counts.put(S.charAt(start), counts.get(S.charAt(start)) - 1);
                count--;
                start++;
                while (start < S.length() && (!expected.containsKey(S.charAt(start)) || expected.get(S.charAt(start)) < counts.get(S.charAt(start)))) {
                    if (expected.containsKey(S.charAt(start)) && expected.get(S.charAt(start)) < counts.get(S.charAt(start))) {
                        counts.put(S.charAt(start), counts.get(S.charAt(start)) - 1);
                    }
                    start++;
                }
            } else {
                end++;
                while (end < S.length() && !expected.containsKey(S.charAt(end))) {
                    end++;
                }
                
                if (end < S.length()) {
                    if (S.charAt(end) == S.charAt(start) && expected.get(S.charAt(end)) <= counts.get(S.charAt(end))) {
                        counts.put(S.charAt(start), counts.get(S.charAt(start)) + 1);
                        while (expected.get(S.charAt(start)) < counts.get(S.charAt(start))) {
                            counts.put(S.charAt(start), counts.get(S.charAt(start)) - 1);
                            start++;
                            while (start < S.length() && !expected.containsKey(S.charAt(start))) {
                                start++;
                            }
                        }
                    } else {
                        if (counts.containsKey(S.charAt(end))) {
                            if (expected.get(S.charAt(end)) > counts.get(S.charAt(end))) {
                                count++;
                            }
                            counts.put(S.charAt(end), counts.get(S.charAt(end)) + 1);
                        } else {
                            count++;
                            counts.put(S.charAt(end), 1);
                        }
                    }
                }
            }
        }
        
        return minString;
    }
}
