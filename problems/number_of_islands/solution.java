class Solution {
  public int numIslands(char[][] grid) {

    int numIslands = 0;

    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] == '1') {
          numIslands += dfs(grid, i, j, visited);
        }
      }
    }
    return numIslands;
  }

  public int dfs(char[][] grid, int r, int c, boolean[][] visited) {
    if (r < 0 || r >= grid.length) {
      return 0;
    }

    if (c < 0 || c >= grid[0].length) {
      return 0;
    }

    if (visited[r][c]) {
      return 0;
    }
    if (grid[r][c] == '0') {
      return 0;
    }
    visited[r][c] = true;
    dfs(grid, r + 1, c, visited);
    dfs(grid, r - 1, c, visited);
    dfs(grid, r, c + 1, visited);
    dfs(grid, r, c - 1, visited);
    return 1;
  }
}
