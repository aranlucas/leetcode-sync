class Solution {
    int[][] DIRS = {
        {2, 1},
        {2, -1},
        {-2, 1},
        {-2, -1},
        {1, 2},
        {1, -2},
        {-1, 2},
        {-1, -2},
    };

    record Pair(int x, int y) {}

    public int minKnightMoves(int x, int y) {
        Deque<Pair> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[607][607];

        q.addLast(new Pair(0, 0));

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.removeFirst();

                if (cur.x == x && cur.y == y) {
                    return level;
                }

                for (int[] dir : DIRS) {
                    int dx = cur.x + dir[0];
                    int dy = cur.y + dir[1];
                    Pair neigh = new Pair(dx, dy);

                    if (!visited[dx + 302][dy + 302]) {
                        visited[dx + 302][dy + 302] = true;
                        q.addLast(neigh);
                    }
                }
            }
            level++;
        }

        return -1;
    }
}
