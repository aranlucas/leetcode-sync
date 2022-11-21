class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adj = new HashMap();
        
        for (int i = 0; i < numCourses; i++) {
            adj.computeIfAbsent(i, k -> new ArrayList());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prereq = prerequisites[i];
            adj.get(prereq[1]).add(prereq[0]);
        }
        
        boolean[] checked = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for (int node: adj.keySet()) {
            if (dfs(adj, node, path, checked)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> adj, int node, boolean[] path, boolean[] checked) {
        // bottom cases
        if (checked[node])
            // this node has been checked, no cycle would be formed with this node.
            return false;
        
        if (path[node]) {
            return true;
        }
        
        if (!adj.containsKey(node)) {
            return false;
        }
        path[node] = true;
        
        boolean ret = false;
        
        for(int neighbor : adj.get(node)) {
            ret = dfs(adj, neighbor, path, checked);
            if (ret) {
                break;
            }
        }
        path[node] = false;
        checked[node] = true;
        return ret;
    }
}