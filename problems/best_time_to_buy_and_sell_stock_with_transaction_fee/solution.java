class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buying = Integer.MIN_VALUE;
        int selling = 0;

        for (int i = 0; i < prices.length; i++) {
            buying = Math.max(buying, selling - prices[i]);
            selling = Math.max(selling, buying + prices[i] - fee);
        }

        return selling;
    }
}
