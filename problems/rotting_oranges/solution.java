class Solution {
    int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        int n = grid.length;
        int m = grid[0].length;

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    q.addLast(new int[] {i, j});
                }
            }
        }
        if (freshOranges == 0) {
            return 0;
        }
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.removeFirst();

                for (int[] dir : DIRS) {
                    int dx = cur[0] + dir[0];
                    int dy = cur[1] + dir[1];

                    if (0 <= dx && dx < n && 0 <= dy && dy < m) {
                        if (grid[dx][dy] == 1) {
                            freshOranges--;
                            grid[dx][dy] = 2;
                            q.addLast(new int[] {dx, dy});
                        }
                    }
                }
            }
            time++;
        }

        return freshOranges == 0 ? time - 1 : -1;
    }
}
