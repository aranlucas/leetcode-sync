class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();

        // Step 1). build the initial set of rotten oranges
        int freshOranges = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[]{ r, c });
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        q.offer(new int[]{ -1, -1 });
        int minutesElapsed = -1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            if (row == -1) {
                minutesElapsed++;
                // to avoid the endless loop
                if (!q.isEmpty()) {
                    q.offer(new int[]{ -1, -1 });
                }
            } else {
                // From the current land cell, traverse to all the four directions
                // and check if it is a water cell. If yes, convert it to land
                // and add it to the queue.
                for (int[] dir : directions) {
                    int x = row + dir[0];
                    int y = col + dir[1];

                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
                        if (grid[x][y] == 1) {
                            // this orange would be contaminated
                            grid[x][y] = 2;
                            freshOranges--;
                            // this orange would then contaminate other oranges
                            q.offer(new int[] { x, y });
                        }
                    }
                }
            }
        }
        return freshOranges == 0 ? minutesElapsed : -1;
    }
}