class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
        rank = new int[size];
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int xset = find(x), yset = find(y);
        if (xset == yset) {
            return;
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset;
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset;
        } else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }
}

class Solution {
    public int minScore(int n, int[][] roads) {
        
        UnionFind uf = new UnionFind(n + 1);

        for (int[] road : roads) {
            uf.union(road[0], road[1]);
        }

        int answer = Integer.MAX_VALUE;
        for (int[] road : roads) {
            if (uf.find(1) == uf.find(road[1])) {
                answer = Math.min(answer, road[2]);
            }
        }

        return answer;
    }
}