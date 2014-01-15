public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] checked = new boolean[9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                checked[j] = false;
            }
            
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                
                if (checked[board[i][j] - '1']) {
                    return false;
                } else {
                    checked[board[i][j] - '1'] = true;
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                checked[j] = false;
            }
            
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                
                if (checked[board[j][i] - '1']) {
                    return false;
                } else {
                    checked[board[j][i] - '1'] = true;
                }
            }
        }
        
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 9; k++) {
                    checked[k] = false;
                }
                
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (board[i + x][j + y] == '.') {
                            continue;
                        }
                        
                        if (checked[board[i + x][j + y] - '1']) {
                            return false;
                        } else {
                            checked[board[i + x][j + y] - '1'] = true;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
