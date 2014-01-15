public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> solutions = new ArrayList<String[]>();
        char[][] solution = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                solution[i][j] = '.';
            }
        }
        
        findSolution(n, 0, solution, solutions);
        
        return solutions;
    }
    
    private void findSolution(int n, int currentRow, char[][] solution, ArrayList<String[]> solutions) {
        if (currentRow == n) {
            String[] finalSol = new String[n];
            for (int i = 0; i < n; i++) {
                finalSol[i] = new String(solution[i]);
            }
            solutions.add(finalSol);
            return;
        }
        
        for (int index = 0; index < n; index++) {
            if (index != 0) {
                solution[currentRow][index - 1] = '.';
            }
            solution[currentRow][index] = 'Q';
            
            boolean isPotentialSolution = true;
            for (int i = currentRow - 1; i >= 0; i--) {
                if (solution[i][index] == 'Q' || ((index - (currentRow - i)) >= 0 && solution[i][index - (currentRow - i)] == 'Q') ||
                ((index + (currentRow - i)) < n && solution[i][index + (currentRow - i)] == 'Q')) {
                    isPotentialSolution = false;
                    break;
                }
            }
            
            if (isPotentialSolution) {
                findSolution(n, currentRow + 1, solution, solutions);
            }
        }
        solution[currentRow][n - 1] = '.';
    }
}
