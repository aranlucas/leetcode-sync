class Solution {
    private int n = 3;
    public String tictactoe(int[][] moves) {
        int[][] board = new int[n][n];
        
        int player = 1;
        
        for (int[] move: moves) {
            int row = move[0];
            int col = move[1];
            
            board[row][col] = player;
            
            if (checkBoard(board, row, col, player)){
                return player == 1 ? "A" : "B";
            }
            
            player *= -1;
        }
        
        System.out.println(Arrays.deepToString(board));
        if (moves.length == n * n) {
            return "Draw";
        }
        
        return "Pending";
    }
    
    private boolean checkBoard(int[][] board, int row, int col, int player) {
        boolean checkRow = checkRow(board, row, player);
        boolean checkCol = checkCol(board, col, player);    
        boolean checkDiagonal = (row == col ) && checkDiagonal(board, player);
        boolean checkAntiDiagonal = (row + col == n - 1) && checkAntiDiagonal(board, player);
        return checkRow || checkCol || checkDiagonal || checkAntiDiagonal;
    }
    
    private boolean checkRow(int[][] board, int row, int player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != player){
                return false;
            }
        }
        return true;
    }
    
    private boolean checkCol(int[][] board, int col, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != player){
                return false;
            }
        }
        return true;
    }
    
    private boolean checkDiagonal(int[][] board, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][row] != player){
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(int[][] board, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][n - 1 - row] != player){
                return false;
            }
        }
        return true;
    }
}