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

    public void join(int node1, int node2) {
        int group1 = find(node1);
        int group2 = find(node2);
        
        // node1 and node2 already belong to same group.
        if (group1 == group2) {
            return;
        }

        if (rank[group1] > rank[group2]) {
            group[group2] = group1;
        } else if (rank[group1] < rank[group2]) {
            group[group1] = group2;
        } else {
            group[group1] = group2;
            rank[group2] += 1;
        }
    }
    
    public boolean areConnected(int node1, int node2) {
        int group1 = find(node1);
        int group2 = find(node2);
        return group1 == group2;
    }
};

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        UnionFind uf = new UnionFind(n);
        int queriesCount = queries.length;
        boolean[] answer = new boolean[queriesCount];
        // Store original indices with all queries.
        int[][] queriesWithIndex = new int[queriesCount][4];
        for (int i = 0; i < queriesCount; ++i) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }

        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(queriesWithIndex, (a, b) -> a[2] - b[2]);

        int edgesIndex = 0;
        for (int i = 0; i < queriesWithIndex.length; i++) {
            int p = queriesWithIndex[i][0];
            int q = queriesWithIndex[i][1];
            int limit = queriesWithIndex[i][2];
            int index = queriesWithIndex[i][3];
            
            while (edgesIndex < edgeList.length && edgeList[edgesIndex][2] < limit) {
                int node1 = edgeList[edgesIndex][0];
                int node2 = edgeList[edgesIndex][1];
                uf.join(node1, node2);
                edgesIndex += 1;
            }

            answer[index] = uf.areConnected(p, q);
        }

        return answer;
    }
}