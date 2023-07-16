class Solution {

    int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1;
        int right = row * col;

        while (left < right) {
            int mid = right - (right - left) / 2;
            if (canCross(row, col, cells, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public boolean canCross(int row, int col, int[][] cells, int days) {
        int[][] matrix = new int[row][col];

        for (int i = 0; i < days; i++) {
            int[] water = cells[i];
            matrix[water[0] - 1][water[1] - 1] = 1;
        }
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                q.offer(new int[] {0, i});
                matrix[0][i] = -1;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == row - 1) {
                return true;
            }

            for (int[] dir : DIRS) {
                int dx = cur[0] + dir[0];
                int dy = cur[1] + dir[1];

                if (dx < row && dx >= 0 && dy < col && dy >= 0) {
                    int nextVal = matrix[dx][dy];
                    if (nextVal == 0) {
                        matrix[dx][dy] = -1;
                        q.offer(new int[] {dx, dy});
                    }
                }
            }
        }
        return false;
    }
}
