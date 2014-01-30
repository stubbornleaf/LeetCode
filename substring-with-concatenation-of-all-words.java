public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> expected = new HashMap<>();
        HashMap<String, Integer> actual = new HashMap<>();
        int length = L[0].length(), i, j;
        
        for (String l : L) {
            if (expected.containsKey(l)) {
                expected.put(l, expected.get(l) + 1);
            } else {
                expected.put(l, 1);
            }
            actual.put(l, 0);
        }
        
        for (i = 0; i <= S.length() - length * L.length; i++) {
            for (j = 0; j < L.length; j++) {
                String tmp = S.substring(i + j * length, i + (j + 1) * length);
                if (expected.containsKey(tmp)) {
                    if (actual.get(tmp) < expected.get(tmp)) {
                        actual.put(tmp, actual.get(tmp) + 1);
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            
            if (j == L.length) {
                result.add(i);
            }
            
            for (String key : actual.keySet()) {
                actual.put(key, 0);
            }
        }
        
        return result;
    }
}
