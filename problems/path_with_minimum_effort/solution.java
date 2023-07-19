class Solution {
    int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        // {x , y, height}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] efforts = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int[] eachRow : efforts) {
            Arrays.fill(eachRow, Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        pq.add(new int[] {0, 0, efforts[0][0]});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (visited[cur[0]][cur[1]]) {
                continue;
            }

            visited[cur[0]][cur[1]] = true;

            if (cur[0] == n - 1 && cur[1] == m - 1) {
                return cur[2];
            }

            for (int[] dir : DIRS) {
                int dx = cur[0] + dir[0];
                int dy = cur[1] + dir[1];

                if (0 <= dx && dx < n && 0 <= dy && dy < m) {
                    if (visited[dx][dy]) {
                        continue;
                    }
                    int currentDifference = Math.abs(heights[dx][dy] - heights[cur[0]][cur[1]]);
                    int maxDifference = Math.max(currentDifference, efforts[cur[0]][cur[1]]);

                    // Previous effort is more than current effort
                    if (efforts[dx][dy] > maxDifference) {
                        efforts[dx][dy] = maxDifference;
                        pq.offer(new int[] {dx, dy, maxDifference});
                    }
                }
            }
        }

        return efforts[n - 1][m - 1];
    }
}
