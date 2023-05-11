class Solution {
    private static final int[][] DIRS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int r, int c, char[][] board, String word, int index) {
        if (index >= word.length()) {
            return true;
        }

        int m = board.length;
        int n = board[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n) {
            return false;
        }

        // Candidates are up down left right
        // Prune candidates that are not the next word
        if (board[r][c] == word.charAt(index)) {
            // Add valid candidate
            board[r][c] = '#';

            boolean ret = false;
            // Explore
            ret =
                    backtrack(r + 1, c, board, word, index + 1)
                            || backtrack(r - 1, c, board, word, index + 1)
                            || backtrack(r, c + 1, board, word, index + 1)
                            || backtrack(r, c - 1, board, word, index + 1);
            // Clean up candidate
            board[r][c] = word.charAt(index);
            return ret;
        }
        return false;
    }
}
