class UnionFind {
    int[] root;

    public UnionFind(int size) {
        root = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int parent) {
        return root[parent];
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
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        UnionFind uf = new UnionFind(n + 1);

        int numberOfConnectedComponents = n;

        for (int[] connection : connections) {
            if (!uf.connected(connection[0], connection[1])) {
                numberOfConnectedComponents--;
                uf.union(connection[0], connection[1]);
            }
        }

        return numberOfConnectedComponents - 1;
    }
}