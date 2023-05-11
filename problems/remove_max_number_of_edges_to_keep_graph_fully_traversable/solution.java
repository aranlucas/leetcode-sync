class UnionFind {
    private int[] group;
    private int[] rank;

    UnionFind(int size) {
        group = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; ++i) {
            group[i] = i;
        }
    }

    public int find(int node) {
        if (group[node] != node) {
            group[node] = find(group[node]);
        }
        return group[node];
    }

    public boolean join(int node1, int node2) {
        int group1 = find(node1);
        int group2 = find(node2);

        // node1 and node2 already belong to same group.
        if (group1 == group2) {
            return false;
        }

        if (rank[group1] > rank[group2]) {
            group[group2] = group1;
        } else if (rank[group1] < rank[group2]) {
            group[group1] = group2;
        } else {
            group[group1] = group2;
            rank[group2] += 1;
        }

        return true;
    }

    public boolean areConnected(int node1, int node2) {
        int group1 = find(node1);
        int group2 = find(node2);
        return group1 == group2;
    }
}
;

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        UnionFind ufAlice = new UnionFind(n + 1);
        UnionFind ufBob = new UnionFind(n + 1);

        int removedEdges = 0, aliceEdges = 0, bobEdges = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (ufAlice.join(edge[1], edge[2])) {
                    ufBob.join(edge[1], edge[2]);
                    aliceEdges++;
                    bobEdges++;
                } else {
                    removedEdges++;
                }
            } else if (edge[0] == 2) {
                if (ufBob.join(edge[1], edge[2])) {
                    bobEdges++;
                } else {
                    removedEdges++;
                }
            } else {
                if (ufAlice.join(edge[1], edge[2])) {
                    aliceEdges++;
                } else {
                    removedEdges++;
                }
            }
        }

        return (bobEdges == n - 1 && aliceEdges == n - 1) ? removedEdges : -1;
    }
}
