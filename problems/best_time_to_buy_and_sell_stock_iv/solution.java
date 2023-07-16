class Solution {
    public int maxProfit(int k, int[] prices) {
        Integer[][][] memo = new Integer[prices.length][k + 1][2];
        // Need to start of buying
        return solve(0, k, 0, prices, memo);
    }

    // holding:
    //      0 if not holding stock
    //      1 if holding a stock
    public int solve(
            int i, int transactionsRemaining, int holding, int[] prices, Integer[][][] memo) {
        if (transactionsRemaining == 0 || i == prices.length) {
            return 0;
        }

        if (memo[i][transactionsRemaining][holding] != null) {
            return memo[i][transactionsRemaining][holding];
        }

        int doNothing = solve(i + 1, transactionsRemaining, holding, prices, memo);

        if (holding == 1) {
            // If you're holding, you can only sell. This increases profit
            int sellStock = prices[i] + solve(i + 1, transactionsRemaining - 1, 0, prices, memo);
            return memo[i][transactionsRemaining][holding] = Math.max(doNothing, sellStock);
        } else {
            // If you're not holding, you can but stock. This decreases profit as you need to
            // re-invest.
            int buyStock = -prices[i] + solve(i + 1, transactionsRemaining, 1, prices, memo);
            return memo[i][transactionsRemaining][holding] = Math.max(doNothing, buyStock);
        }
    }
}
