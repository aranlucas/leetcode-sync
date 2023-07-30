class Solution {

    int[][] DIRS = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int answer = 0;
        HashMap<Integer, Integer> area = new HashMap<>();
        int index = 3;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int connected = dfs(new int[] { i, j}, grid, new boolean[n][m], index);
                    area.put(index, connected);
                    answer = Math.max(answer, connected);
                    index++;
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    for (int[] dir : DIRS) {
                        int dx = r + dir[0];
                        int dy = c + dir[1];
                        if (0 <= dx && dx < n && 0 <= dy && dy < n) {
                            if (grid[dx][dy] > 1) {
                                seen.add(grid[dx][dy]);
                            }
                        }
                    }

                    int connectedArea = 1;
                    for (int i: seen) {
                        connectedArea += area.get(i);
                    }
                    answer = Math.max(answer, connectedArea);
                }
            }
        }
        return answer;
    }

    public int dfs(int[] start, int[][] grid, boolean[][] seen, int index) {
        int n = grid.length;
        seen[start[0]][start[1]] = true;
        grid[start[0]][start[1]] = index;
        int answer = 1;
        for (int[] dir: DIRS) {
            int dx = start[0] + dir[0];
            int dy = start[1] + dir[1];

            if (0 <= dx && dx < n && 0 <= dy && dy < n) {
                if (seen[dx][dy] || grid[dx][dy] == 0) {
                    continue;
                }
                answer += dfs(new int[] {dx, dy}, grid, seen, index);
            }
        }

        return answer;
    }
}