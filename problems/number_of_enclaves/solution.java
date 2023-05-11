class Solution {

    int[][] DIRS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            // First column.
            if (grid[i][0] == 1 && !visited[i][0]) {
                dfs(i, 0, grid, visited);
            }

            // Last column.
            if (grid[i][n - 1] == 1 && !visited[i][n - 1]) {
                dfs(i, n - 1, grid, visited);
            }
        }

        for (int i = 0; i < n; i++) {
            // First row.
            if (grid[0][i] == 1 && !visited[0][i]) {
                dfs(0, i, grid, visited);
            }
            // Last row.
            if (grid[m - 1][i] == 1 && !visited[m - 1][i]) {
                dfs(m - 1, i, grid, visited);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int x, int y, int[][] grid, boolean[][] visited) {
        if (x < 0
                || x >= grid.length
                || y < 0
                || y >= grid[0].length
                || grid[x][y] == 0
                || visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        for (int[] dir : DIRS) {
            dfs(x + dir[0], y + dir[1], grid, visited);
        }
        return;
    }
}
