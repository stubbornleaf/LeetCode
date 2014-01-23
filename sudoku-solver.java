public class Solution {
    public void solveSudoku(char[][] board) {
        trySolution(board);
    }
    
    private boolean trySolution(char[][] board) {
        int m = 0, n = 0;
        for (; n < 9; n++) {
            boolean filled = true;
            for (m = 0; m < 9; m++) {
                if (board[n][m] == '.') {
                    filled = false;
                    break;
                }
            }
            if (!filled) {
                break;
            }
        }
        
        if (n == 9) {
            return true;
        }
        
        boolean[] checked = new boolean[9];
        
        for (int i = 0; i < 9; i++) {
            if (board[n][i] != '.') {
                checked[board[n][i] - '1'] = true;
            }
            if (board[i][m] != '.') {
                checked[board[i][m] - '1'] = true;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[n - (n % 3) + i][m - (m % 3) + j] != '.') {
                    checked[board[n - (n % 3) + i][m - (m % 3) + j] - '1'] = true;
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (!checked[i]) {
                board[n][m] = (char)(i + 1 + '0');
                boolean tmp = trySolution(board);
                if (tmp) {
                    return true;
                }
            }
        }
        
        board[n][m] = '.';
        return false;
    }
}
