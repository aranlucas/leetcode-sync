class Solution {
  public int nearestExit(char[][] maze, int[] entrance) {

    Deque<int[]> q = new ArrayDeque();

    boolean[][] visited = new boolean[maze.length][maze[0].length];

    q.offer(new int[] {entrance[0], entrance[1], 0});

    visited[entrance[0]][entrance[1]] = true;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    while (!q.isEmpty()) {
      int[] curr = q.poll();

      for (int[] dir : dirs) {
        int i = curr[0] + dir[0];
        int j = curr[1] + dir[1];

        if (i < 0
            || j < 0
            || i >= maze.length
            || j >= maze[0].length
            || visited[i][j]
            || maze[i][j] == '+') {
          continue;
        }

        if (isExit(i, j, maze)) {
          return curr[2] + 1;
        }

        visited[i][j] = true;
        q.offer(new int[] {i, j, curr[2] + 1});
      }
    }

    return -1;
  }

  public boolean isExit(int nextRow, int nextCol, char[][] maze) {
    return (nextRow == 0
        || nextRow == maze.length - 1
        || nextCol == 0
        || nextCol == maze[0].length - 1);
  }
}
