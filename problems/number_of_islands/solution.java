class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        
        for (int r = 0; r < grid.length; ++r) {
          for (int c = 0; c < grid[0].length; ++c) {
            if (grid[r][c] == '1') {
              numIslands++;
              dfs(grid, r, c);
            }
          }
        }
        return numIslands; 
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}