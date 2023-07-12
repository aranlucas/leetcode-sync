class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                char curr = board[r][c];

                if (curr == '.') {
                    continue;
                }

                // Check row
                if (!seen.add(curr + "in row" + r)) {
                    return false;
                }

                // Check column
                if (!seen.add(curr + "in column" + c)) {
                    return false;
                }

                // Check block
                if (!seen.add(curr + "in block" +  r/3 + "-" + c/3)) {
                    return false;
                }
            }
        }

        return true;
    }
}