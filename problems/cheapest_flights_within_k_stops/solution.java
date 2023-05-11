class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = distances.clone();

            for (int[] edge : flights) {
                int s = edge[0]; // from
                int d = edge[1]; // to
                int weight = edge[2]; // price

                // Do we replace the value?
                if (distances[s] != Integer.MAX_VALUE) {
                    // Relax the edge if possible. Previous price + new weight
                    if (distances[s] + weight < temp[d]) {
                        temp[d] = distances[s] + weight;
                    }
                }
            }
            distances = temp;
        }

        if (distances[dst] != Integer.MAX_VALUE) {
            return distances[dst];
        }

        return -1;
    }
}
