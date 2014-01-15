public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> solutions = new ArrayList<ArrayList<String>>();
        ArrayList<String> solution = new ArrayList<String>();
        ArrayList<ArrayList<Integer>> palindromes = new ArrayList<ArrayList<Integer>>();
        
        if (s == null || s.length() == 0) return solutions;
        
        for (int i = 0; i < s.length(); i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    tmp.add(j - i + 1);
                }
            }
            palindromes.add(tmp);
        }
        
        findSolution(s, palindromes, 0, solution, solutions);
        
        return solutions;
    }
    
    private void findSolution(String s, ArrayList<ArrayList<Integer>> palindromes, int position, ArrayList<String> solution, ArrayList<ArrayList<String>> solutions) {
        if (position >= s.length()) {
            solutions.add(new ArrayList<String>(solution));
            return;
        }
        
        ArrayList<Integer> palindrome = palindromes.get(position);
        for (int i = 0; i < palindrome.size(); i++) {
            solution.add(s.substring(position, position + palindrome.get(i)));
            findSolution(s, palindromes, position + palindrome.get(i), solution, solutions);
            solution.remove(solution.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        
        boolean isPalindrome = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        
        return isPalindrome;
    }
}
