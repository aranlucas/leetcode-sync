class Solution {
    public int numIslands(char[][] grid) {

        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    islands++;
                    dfs(i, j, grid, visited);
                }
            }
        }

        return islands;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0
                || j < 0
                || i >= grid.length
                || j >= grid[0].length
                || visited[i][j]
                || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        dfs(i + 1, j, grid, visited);
        dfs(i, j + 1, grid, visited);
        dfs(i - 1, j, grid, visited);
        dfs(i, j - 1, grid, visited);
    }
}
