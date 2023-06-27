class Solution {
    public int maxProfit(int[] prices) {
      Integer[][][] memo = new Integer[prices.length][2][2];
      return solve(0, 0, 0, prices, memo);
    }


    public int solve(int index, int cooldown, int holding, int[] prices, Integer[][][] memo) {
      if (index == prices.length) {
        return 0;
      }

      if (memo[index][cooldown][holding] != null) {
        return memo[index][cooldown][holding];
      }

      int doNothing = solve(index + 1, 0, holding, prices, memo);


      // holding 0 => means you need to buy stock
      if (holding == 0) {
        // Check cooldown
        if (cooldown == 0) {
          int buyStock = -prices[index] + solve(index + 1, 0, 1, prices, memo);

          return memo[index][cooldown][holding] = Math.max(buyStock, doNothing);
        }

        return doNothing;
      } else {
        int sellStock = prices[index] + solve(index + 1, 1, 0, prices, memo);
        return memo[index][cooldown][holding] = Math.max(doNothing,  sellStock);
      }
    }
}