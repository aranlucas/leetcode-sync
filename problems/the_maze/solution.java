class Solution {
    
    int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Deque<int[]> q = new ArrayDeque<int[]>();

        q.addLast(start);

        while(!q.isEmpty()) {
            int[] curr = q.removeFirst();

            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }

            for (int[] dir : DIRS) {
                int dx = curr[0] + dir[0];
                int dy = curr[1] + dir[1];

                while (dx >= 0 && dy >= 0 && dx < maze.length && dy < maze[0].length && maze[dx][dy] == 0) {
                    dx += dir[0];
                    dy += dir[1];
                }
                if (!visited[dx - dir[0]][dy - dir[1]]) {
                    q.add(new int[] {dx - dir[0], dy - dir[1]});
                    visited[dx - dir[0]][dy - dir[1]] = true;
                }
            }
        }
        return false;
    }
}