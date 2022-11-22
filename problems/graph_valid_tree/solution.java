class UnionFind {
    int[] root;
    
    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }
    
    public int find(int n) {
        return root[n];
    }
    
    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        if (rootA != rootB) {
            for (int i = 0; i < root.length; i++){
                // Replace all of rootB with rootA;
                if (root[i] == rootB) {
                    root[i] = rootA;
                }
            }
        }
        
        return true;
    }
    
    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Condition 1: The graph must contain n - 1 edges.
        if (edges.length != n - 1) return false;
        
        UnionFind union = new UnionFind(n);
        
        for (int[] edge: edges) {
            if(union.connected(edge[0], edge[1])) {
                return false;
            }
            union.union(edge[0], edge[1]);
        }
        
        return true;
    }
}