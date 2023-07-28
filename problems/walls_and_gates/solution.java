class Solution {

    int[][] DIRS = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    int GATE = 0;
    int EMPTY = Integer.MAX_VALUE;
    int WALL = -1;

    public void wallsAndGates(int[][] rooms) {
        int n = rooms.length;
        int m = rooms[0].length;

        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == GATE) {
                    // Begin search from all gates
                    q.add(new int[] { i, j});
                }
            }
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int[] cur = q.pop();

                for (int[] dir: DIRS) {
                    int dx = cur[0] + dir[0];
                    int dy = cur[1] + dir[1];

                    if (0 <= dx && dx < n && 0 <= dy && dy < m) {
                        // Skip walls and obstacles
                        if (rooms[dx][dy] == WALL) {
                            continue;
                        }
                        // Skip if visited already
                        if (rooms[dx][dy] != EMPTY) {
                            continue;
                        }

                        rooms[dx][dy] = level + 1;
                        q.add(new int[] {dx, dy});
                    }
                }
            }
            level++;
        }
    }
}