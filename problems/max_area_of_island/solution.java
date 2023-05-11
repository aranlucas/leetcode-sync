class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(dfs(grid, i, j, visited), maxArea);
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        // Out of bound checks
        if (r < 0 || r >= grid.length) {
            return 0;
        }

        if (c < 0 || c >= grid[0].length) {
            return 0;
        }

        // Check if visited
        if (visited[r][c]) {
            return 0;
        }

        // Water check
        if (grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;
        int area = 1;

        area += dfs(grid, r + 1, c, visited);
        area += dfs(grid, r - 1, c, visited);
        area += dfs(grid, r, c + 1, visited);
        area += dfs(grid, r, c - 1, visited);

        return area;
    }
}
