class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        List<List<String>> result = new ArrayList();
        backtrack(0, board, result);
        
        return result;
    }
    
    public void backtrack(int row, char[][] board, List<List<String>> result){
        // Solved the problem, add result
        if (row == board.length){
            ArrayList<String> boardString = createAnswer(board);
            result.add(boardString);
        }
        
        
        // Add the candidates
        // We know that queens can be placed in any column
        for (int col = 0; col < board.length; col++) {
            // Current candidate is board[r][c]
            if (isSafe(board, row, col)){
                board[row][col] = 'Q';
                backtrack(row + 1, board, result);
                board[row][col] = '.';
            }
        }
    }
    
    public boolean isSafe(char[][] board, int row, int col){
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i] == 'Q') {
                return false;
            }
        }
        int maxRight = Math.min(row, board.length - 1 - col);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i] == 'Q') {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<String> createAnswer(char[][] board) {
        ArrayList<String> ans = new ArrayList();
        for (int i = 0; i < board.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    str.append("Q");
                } else str.append(".");
            }
            ans.add(str.toString());
        }
        
        return ans;
    }
}