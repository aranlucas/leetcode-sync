class Solution {
    int[][] DIRECTIONS = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        // Firstly, we need to check that the start and target cells are open.
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }

            for (int[] dir: DIRECTIONS) {
                int dx = cell[0] + dir[0];
                int dy = cell[1] + dir[1];

                if (dx < 0 || dy < 0 || dx >= grid.length|| dy >= grid[0].length) {
                    continue;
                }

                if (grid[dx][dy] != 0) {
                    continue;
                }

                queue.add(new int[] {dx, dy});
                grid[dx][dy] = distance + 1;
            }
        }

        return -1;
    }
}