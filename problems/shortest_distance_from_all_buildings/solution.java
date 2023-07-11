class Solution {
    int[][] DIRS = {{0, 1} , {1,0}, {-1, 0}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        
        int buildingCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    buildingCount++;
                } 
            }
        }

        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    minDistance = Math.min(minDistance, bfs(grid, i, j, buildingCount));
                }
            }
        }

        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }

        return minDistance;
    }

    public int bfs(int[][] grid, int x, int y, int buildingCount) {
        System.out.println(x + " " + y);
        int n = grid.length;
        int m = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        int buildingsFound = 0;
        boolean[][] vis = new boolean[n][m];

        q.addLast(new int[] { x, y });
        vis[x][y] = true;
        int level = 0;
        int pathDistance = 0;
        while (!q.isEmpty() && buildingsFound != buildingCount) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int[] cur = q.removeFirst();

                if (grid[cur[0]][cur[1]] == 1) {
                    pathDistance += level;
                    buildingsFound++;
                    continue;
                }
                for (int[] dir: DIRS) {
                    int dx = cur[0] + dir[0];
                    int dy = cur[1] + dir[1];

                    if (dx >= 0 && dx < n && dy >= 0 && dy < m) {
                        if (!vis[dx][dy] && grid[dx][dy] != 2) {
                            q.addLast(new int[] {dx, dy});
                            vis[dx][dy] = true;
                        }
                    }
                }
            }
            level++;
        }
        if (buildingsFound != buildingCount) {
            return Integer.MAX_VALUE;
        }
        return pathDistance;
    }
}