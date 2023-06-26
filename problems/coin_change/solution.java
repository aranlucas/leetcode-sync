class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1];
        int res = solve(coins, amount, memo);
        return res;
    }

    public int solve(int[] coins, int amount, Integer[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        if (memo[amount] != null) {
            return memo[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int solve = solve(coins, amount - coins[i], memo);
            if (solve != - 1) {
                min = Math.min(min, solve + 1);
            }
        
        }
        
        return memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
    }
}