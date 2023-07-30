class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        int l = n + 1;
        int[] inDegrees = new int[l];
        boolean[][] isConnected = new boolean[l][l];
        int ans = Integer.MAX_VALUE;
        
        for(int[] edge : edges){
            isConnected[edge[0]][edge[1]] = true;
            isConnected[edge[1]][edge[0]] = true;
            inDegrees[edge[0]]++;
            inDegrees[edge[1]]++;
        }
        
        for(int i = 0; i < l; i++) {
            for (int j = 0 ; j < l; j++) {
                for (int k = 0; k < l; k++) {
                    if (isConnected[i][j] && isConnected[j][k] && isConnected[k][i]) {
                        ans = Math.min(ans, inDegrees[i] + inDegrees[j] + inDegrees[k] - 6);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}