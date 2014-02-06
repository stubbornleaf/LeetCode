public class Solution {
    class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public void solve(char[][] board) {
        if (board.length == 0) return;
        
        int width = board.length, length = board[0].length;
        LinkedList<Position> queue = new LinkedList<>();
        boolean[][] checked = new boolean[width][length];
        
        for (int i = 0; i < length; i++) {
            if (board[0][i] == 'O') {
                checked[0][i] = true;
                queue.offer(new Position(0, i));
                flip(board, checked, queue, width, length);
            }
        }
        for (int i = 0; i < length; i++) {
            if (board[width - 1][i] == 'O') {
                checked[width - 1][i] = true;
                queue.offer(new Position(width - 1, i));
                flip(board, checked, queue, width, length);
            }
        }
        for (int i = 0; i < width; i++) {
            if (board[i][0] == 'O') {
                checked[i][0] = true;
                queue.offer(new Position(i, 0));
                flip(board, checked, queue, width, length);
            }
        }
        for (int i = 0; i < width; i++) {
            if (board[i][length - 1] == 'O') {
                checked[i][length - 1] = true;
                queue.offer(new Position(i, length - 1));
                flip(board, checked, queue, width, length);
            }
        }
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'o') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void flip(char[][] board, boolean[][] checked, LinkedList<Position> queue, int width, int length) {
        HashSet<Position> set = new HashSet<>();
        
        while (queue.size() > 0) {
            Position position = queue.poll();
            set.add(position);
            
            int x = position.x, y = position.y;
            if (x > 0 && !checked[x - 1][y]) {
                if (board[x - 1][y] == 'O') {
                    checked[x - 1][y] = true;
                    queue.offer(new Position(x - 1, y));
                }
            }
            if (x < (width - 1) && !checked[x + 1][y]) {
                if (board[x + 1][y] == 'O') {
                    checked[x + 1][y] = true;
                    queue.offer(new Position(x + 1, y));
                }
            }
            if (y > 0 && !checked[x][y - 1]) {
                if (board[x][y - 1] == 'O') {
                    checked[x][y - 1] = true;
                    queue.offer(new Position(x, y - 1));
                }
            }
            if (y < (length - 1) && !checked[x][y + 1]) {
                if (board[x][y + 1] == 'O') {
                    checked[x][y + 1] = true;
                    queue.offer(new Position(x, y + 1));
                }
            }
        }
        
        for (Position p : set) {
            board[p.x][p.y] = 'o';
        }
    }
}
