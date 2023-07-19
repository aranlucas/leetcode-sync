class Solution {
    int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] seen = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();

        q.addFirst(new int[] {0, 0});
        seen[0][0] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.removeFirst();

                if (cur[0] == n - 1 && cur[1] == m - 1) {
                    return level + 1;
                }

                for (int[] dir : DIRS) {
                    int dx = cur[0] + dir[0];
                    int dy = cur[1] + dir[1];

                    if (0 <= dx && dx < n && 0 <= dy && dy < m) {
                        if (seen[dx][dy]) {
                            continue;
                        }
                        if (grid[dx][dy] != 0) {
                            continue;
                        }
                        seen[dx][dy] = true;
                        q.addLast(new int[] {dx, dy});
                    }
                }
            }

            level++;
        }
        return -1;
    }
}
