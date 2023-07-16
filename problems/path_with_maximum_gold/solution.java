class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int maxGold = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    boolean[][] visited = new boolean[n][m];
                    maxGold = Math.max(dfs(i, j, grid, visited), maxGold);
                }
            }
        }

        return maxGold;
    }

    public int dfs(int x, int y, int[][] grid, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y]) {
            return 0;
        }

        if (grid[x][y] == 0) {
            return 0;
        }

        visited[x][y] = true;

        int one = dfs(x + 1, y, grid, visited);
        int two = dfs(x, y + 1, grid, visited);
        int three = dfs(x - 1, y, grid, visited);
        int four = dfs(x, y - 1, grid, visited);
        visited[x][y] = false;

        return Math.max(four, Math.max(three, Math.max(two, one))) + grid[x][y];
    }
}
