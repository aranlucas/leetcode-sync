class Solution {
    int[][] DIRS = {{0,1}, {1,0}, {-1, 0}, {0,-1}};

    public int maximumMinimumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->  b[2] - a[2]);

        boolean[][] visited = new boolean[n][m];
        pq.add(new int[] { 0, 0, grid[0][0]});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[0] == n - 1 && cur[1] == m - 1) {
                return cur[2];
            }

            for (int[] dir : DIRS) {
                int dx = cur[0] + dir[0];
                int dy = cur[1] + dir[1];

                if (dx >= 0 && dx < n && dy >= 0 && dy < m){
                    if (!visited[dx][dy]) {
                        pq.add(new int[] {dx, dy, Math.min(grid[dx][dy], cur[2])});
                        visited[dx][dy] = true;
                    }
                }
            }
        }

        return -1;
    }
}