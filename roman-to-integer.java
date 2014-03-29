public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        map.put(new Character('I'), 1);
        map.put(new Character('V'), 5);
        map.put(new Character('X'), 10);
        map.put(new Character('L'), 50);
        map.put(new Character('C'), 100);
        map.put(new Character('D'), 500);
        map.put(new Character('M'), 1000);
        
        result = map.get(new Character(s.charAt(s.length() - 1)));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(new Character(s.charAt(i))) < map.get(new Character(s.charAt(i + 1)))) {
                result -= map.get(new Character(s.charAt(i)));
            } else {
                result += map.get(new Character(s.charAt(i)));
            }
        }
        
        return result;
    }
}
