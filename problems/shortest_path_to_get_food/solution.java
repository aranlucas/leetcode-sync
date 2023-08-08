class Solution {
    int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int getFood(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] start = findStart(grid);

        Deque<int[]> q = new ArrayDeque<>();
        q.add(start);

        boolean[][] seen = new boolean[n][m];
        seen[start[0]][start[1]] = true;

        int length = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.removeFirst();

                if (grid[cur[0]][cur[1]] == '#') {
                    return length;
                }

                for (int[] dir : DIRS) {
                    int dx = cur[0] + dir[0];
                    int dy = cur[1] + dir[1];

                    if (0 <= dx && dx < n && 0 <= dy && dy < m) {
                        if (seen[dx][dy] || grid[dx][dy] == 'X') {
                            continue;
                        }
                        seen[dx][dy] = true;
                        int[] nei = new int[] {dx, dy};
                        q.addLast(nei);
                    }
                }
            }
            length++;
        }

        return -1;
    }

    private int[] findStart(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '*') {
                    return new int[] {i, j};
                }
            }
        }

        return new int[2];
    }
}
