class Solution {
    public int maxProfit(int[] prices) {

        int left = 0;
        int maxProfit = 0;
        for (int right = 1; right < prices.length; right++) {
            int windowProfit = prices[right] - prices[left];

            if (prices[left] > prices[right]) {
                left = right;
            }

            maxProfit = Math.max(windowProfit, maxProfit);
        }

        return maxProfit;
    }
}
