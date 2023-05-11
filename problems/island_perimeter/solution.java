class Solution {
    public int islandPerimeter(int[][] grid) {

        Set<String> visited = new HashSet();

        int perimeter = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && !visited.contains(key(r, c))) {
                    perimeter += dfs(r, c, grid, visited);
                }
            }
        }
        return perimeter;
    }

    public int dfs(int r, int c, int[][] grid, Set<String> visited) {
        if (r < 0 || r >= grid.length) {
            return 1;
        }
        if (c < 0 || c >= grid[0].length) {
            return 1;
        }

        if (grid[r][c] == 0) {
            return 1;
        }

        if (visited.contains(key(r, c))) {
            return 0;
        }

        visited.add(key(r, c));

        int perimeter = 0;
        perimeter += dfs(r + 1, c, grid, visited);
        perimeter += dfs(r - 1, c, grid, visited);
        perimeter += dfs(r, c + 1, grid, visited);
        perimeter += dfs(r, c - 1, grid, visited);

        return perimeter;
    }

    public String key(int r, int c) {
        return String.format("%d,%d", r, c);
    }
}
