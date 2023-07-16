class Solution {
    int[][] DIRS = {
        {2, 1},
        {2, -1},
        {-2, 1},
        {-2, -1},
        {1, 2},
        {1, -2},
        {-1, 2},
        {-1, -2},
    };

    public int[][] tourOfKnight(int m, int n, int r, int c) {
        int[][] board = new int[m][n];
        int[][] result = new int[m][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = -1;
            }
        }
        board[r][c] = 0;
        backtrack(r, c, 0, m, n, result, board);
        return result;
    }

    public void backtrack(int i, int j, int step, int m, int n, int[][] result, int[][] currBoard) {
        if (step == m * n - 1) {
            for (int k = 0; k < m; k++) {
                for (int l = 0; l < n; l++) {
                    result[k][l] = currBoard[k][l];
                }
            }
            return;
        }

        for (int[] dir : DIRS) {
            int dx = dir[0] + i;
            int dy = dir[1] + j;

            if (dx >= 0 && dx < m && dy >= 0 && dy < n && currBoard[dx][dy] == -1) {
                currBoard[dx][dy] = ++step;
                backtrack(dx, dy, step, m, n, result, currBoard);
                currBoard[dx][dy] = -1;
                ;
                step--;
            }
        }
    }
}
