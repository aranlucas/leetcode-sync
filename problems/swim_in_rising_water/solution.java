class Solution {

    int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int swimInWater(int[][] grid) {

        int n = grid.length;
        int lo = grid[0][0];
        int hi = n * n;

        int answer = -1;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (possible(mid, grid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public boolean possible(int time, int[][] grid) {
        int n = grid.length;
        boolean[][] seen = new boolean[n][n];
        Deque<int[]> q = new ArrayDeque<>();
        int[] start = new int[] {0, 0};
        seen[0][0] = true;
        q.addLast(start);

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            if (cur[0] == n - 1 && cur[1] == n - 1) {
                return true;
            }

            for (int[] dir : DIRS) {
                int dx = cur[0] + dir[0];
                int dy = cur[1] + dir[1];
                if (0 <= dx && dx < n && 0 <= dy && dy < n) {
                    if (seen[dx][dy]) {
                        continue;
                    }
                    if (grid[dx][dy] <= time) {
                        seen[dx][dy] = true;
                        q.addLast(new int[] {dx, dy});
                    }
                }
            }
        }

        return false;
    }
}
