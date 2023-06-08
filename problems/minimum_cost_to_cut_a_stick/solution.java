class Solution {
    private int cost(int left, int right, int[][] memo, int[] newCuts) {
        if (memo[left][right] != -1) {
            return memo[left][right];
        }
        if (right - left == 1) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int mid = left + 1; mid < right; mid++) {
            int cost =
                    cost(left, mid, memo, newCuts)
                            + cost(mid, right, memo, newCuts)
                            + newCuts[right]
                            - newCuts[left];
            ans = Math.min(ans, cost);
        }
        memo[left][right] = ans;
        return ans;
    }

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] newCuts = new int[m + 2];
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[m + 1] = n;
        Arrays.sort(newCuts);

        int[][] memo = new int[m + 2][m + 2];
        for (int r = 0; r < m + 2; ++r) {
            Arrays.fill(memo[r], -1);
        }

        return cost(0, newCuts.length - 1, memo, newCuts);
    }
}
