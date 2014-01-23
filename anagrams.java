public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String s = new String(array);
            ArrayList<String> tmp;
            if (map.containsKey(s)) {
                tmp = map.get(s);
            } else {
                tmp = new ArrayList<String>();
            }
            tmp.add(str);
            map.put(s, tmp);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.addAll(map.get(key));
            }
        }
        
        return result;
    }
}
