class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Set<String> visited = new HashSet();
        
        int maxArea = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                String key = key(r,c);
                if (grid[r][c] != 0 && !visited.contains(key)){
                    maxArea = Math.max(maxArea, dfs(r, c, grid, visited));
                }
            }
        }
        return maxArea;
    }
    
    public int dfs(int r, int c, int[][] graph, Set<String> visited){
        if(r < 0 || r >= graph.length){
            return 0;
        }
        
        if(c < 0 || c >= graph[0].length){
            return 0;
        }
        
        String key = key(r,c);
        
        if (visited.contains(key)){
            return 0;
        }
        
        if (graph[r][c] == 0){
            return 0;
        }
        
        visited.add(key);
        
        int area = 1;
        area += dfs(r+1,c,graph,visited);
        area += dfs(r-1,c,graph,visited);
        area += dfs(r,c+1,graph,visited);
        area += dfs(r,c-1,graph,visited);
        
        return area;
    }
    
    public String key(int r, int c){
        return r + "," + c;
    }
}