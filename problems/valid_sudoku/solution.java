class Solution {
  public boolean isValidSudoku(char[][] board) {
    Set<String> seen = new HashSet<String>();

    // row
    for (int r = 0; r < board.length; r++) {
      // column
      for (int c = 0; c < board[r].length; c++) {
        char curr = board[r][c];

        if (curr == '.') {
          continue;
        }
        if (!seen.add(curr + " in row " + r)
            || !seen.add(curr + " in column " + c)
            || !seen.add(curr + " in block " + r / 3 + "-" + c / 3)) {
          return false;
        }
      }
    }

    return true;
  }
}
