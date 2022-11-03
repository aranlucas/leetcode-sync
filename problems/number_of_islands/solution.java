class Solution {
    public int numIslands(char[][] grid) {
        Set<String> visited = new HashSet();
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                String current = generateKey(i,j);
                if (!visited.contains(current) && grid[i][j] == '1'){
                    System.out.println("Visiting " + generateKey(i,j));
                    numIslands += 1;
                    dfs(i, j, visited, grid);
                }
            }
        }
        System.out.println(visited);
        return numIslands;
    }
    
    public void dfs(int x, int y, Set<String> visited, char[][] grid) {
        // Out of bound checks
        if (x < 0 || x >= grid.length) {
            return;
        }
        if (y < 0 || y >= grid[0].length) {
            return;
        }
        
        String current = generateKey(x,y);
        
        if (visited.contains(current)) {
            return;
        }
        if (grid[x][y] == '0'){
            return;
        }
        System.out.println("Visiting " + generateKey(x,y));
        visited.add(current);
        // DFS in all 4 directions
        
        dfs(x + 1, y, visited, grid);
        dfs(x - 1, y, visited, grid);
        dfs(x, y+1, visited, grid);
        dfs(x, y-1, visited, grid);
    }
    
    public String generateKey(int x, int y){
        return String.format("%d,%d", x, y);
    }
}