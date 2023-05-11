class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length + 2];

        for (int i = prices.length - 1; i >= 0; i--) {
            int C1 = 0;
            // Case 1). buy and sell the stock
            for (int sell = i + 1; sell < prices.length; sell++) {
                int profit = (prices[sell] - prices[i]) + dp[sell + 2];
                C1 = Math.max(profit, C1);
            }

            // Case 2). do no transaction with the stock p[i]
            int C2 = dp[i + 1];

            // wrap up the two cases
            dp[i] = Math.max(C1, C2);
        }
        return dp[0];
    }
}
