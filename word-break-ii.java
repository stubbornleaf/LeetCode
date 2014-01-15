public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<ArrayList<Integer>> steps = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < s.length(); i++) {
            steps.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < s.length(); i++) {
            for (String word : dict) {
                if ((word.length() + i) <= s.length() && word.equals(s.substring(i, i + word.length()))) {
                    steps.get(i + word.length() - 1).add(word.length());
                }
            }
        }
        
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        findSentence(s, result, sb, steps, s.length() - 1);
        
        return result;
    }
    
    private void findSentence(String s, ArrayList<String> result, StringBuilder sb, ArrayList<ArrayList<Integer>> steps, int position) {
        if (position < 0) {
            String tmp = sb.toString();
            result.add(tmp.substring(0, tmp.length() - 1));
            return;
        }
        
        ArrayList<Integer> step = steps.get(position);
        for (Integer back : step) {
            sb.insert(0, s.substring(position - back + 1, position + 1) + " ");
            findSentence(s, result, sb, steps, position - back);
            sb.delete(0, back + 1);
        }
    }
}
