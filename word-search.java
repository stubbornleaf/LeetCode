public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    boolean exist = search(board, used, word, 1, i, j);
                    if (exist) {
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][] board, boolean[][] used, String word, int current, int i, int j) {
        if (current == word.length()) {
            return true;
        }
        
        boolean exist;
        if ((j - 1) >= 0 && !used[i][j - 1] && board[i][j - 1] == word.charAt(current)) {
            used[i][j - 1] = true;
            exist = search(board, used, word, current + 1, i, j - 1);
            if (exist) {
                return true;
            }
            used[i][j - 1] = false;
        }
        if ((j + 1) < board[0].length && !used[i][j + 1] && board[i][j + 1] == word.charAt(current)) {
            used[i][j + 1] = true;
            exist = search(board, used, word, current + 1, i, j + 1);
            if (exist) {
                return true;
            }
            used[i][j + 1] = false;
        }
        if ((i - 1) >= 0 && !used[i - 1][j] && board[i - 1][j] == word.charAt(current)) {
            used[i - 1][j] = true;
            exist = search(board, used, word, current + 1, i - 1, j);
            if (exist) {
                return true;
            }
            used[i - 1][j] = false;
        }
        if ((i + 1) < board.length && !used[i + 1][j] && board[i + 1][j] == word.charAt(current)) {
            used[i + 1][j] = true;
            exist = search(board, used, word, current + 1, i + 1, j);
            if (exist) {
                return true;
            }
            used[i + 1][j] = false;
        }
        
        return false;
    }
}
