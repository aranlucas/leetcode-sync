class Solution {
    int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int closedIsland(int[][] grid) {

        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j] && dfs(grid, i, j, visited)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }

        if (grid[x][y] == 1 || visited[x][y]) {
            return true;
        }
        ;

        visited[x][y] = true;

        boolean res = true;

        for (int[] d : dir) {
            res = res & dfs(grid, x + d[0], y + d[1], visited);
        }

        return res;
    }
}
