class Solution {
    int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    private void dfs(int[][] grid, int x, int y, Deque<int[]> q) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1 || grid[x][y] == 0) {
            return;
        }
        

        grid[x][y] = -1;
        q.offer(new int[]{ x , y });
        dfs(grid, x - 1, y, q); //Top
        dfs(grid, x, y + 1, q); //Right
        dfs(grid, x + 1, y, q); //Bottom 
        dfs(grid, x, y - 1, q); //Left

        return;
    }

    public int shortestBridge(int[][] grid) {

        Deque<int[]> q = new ArrayDeque<>();
        boolean flag = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, q);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();

                for (int[] dir: DIRS) {
                    int dx = dir[0] + cur[0];
                    int dy = dir[1] + cur[1];
                    
                    if (0 <= dx && dx < grid.length && 0 <= dy && dy < grid[0].length && grid[dx][dy] != -1) {
                        if (grid[dx][dy] == 1) {
                            return distance;
                        } else if (grid[dx][dy] == 0) {
                            grid[dx][dy] = -1;
                            q.offer(new int[] {dx, dy});
                        }
                    }

                }
            }

            distance++;
        }

        return distance;
    }
}