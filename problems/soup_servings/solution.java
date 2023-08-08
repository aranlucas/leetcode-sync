class Solution {
    public double soupServings(int n) {
        if (n > 5000) {
            return 1.0;
        }
        Double[][] memo = new Double[n + 1][n + 1];
        return solve(n, n, memo);
    }

    public double solve(int soupA, int soupB, Double[][] memo) {
        if (soupA <= 0 && soupB <= 0) {
            return 0.5;
        }

        if (soupA <= 0) {
            return 1;
        }

        if (soupB <= 0) {
            return 0;
        }

        if (memo[soupA][soupB] != null) {
            return memo[soupA][soupB];
        }

        double total =
                solve(soupA - 100, soupB - 0, memo)
                        + solve(soupA - 75, soupB - 25, memo)
                        + solve(soupA - 50, soupB - 50, memo)
                        + solve(soupA - 25, soupB - 75, memo);

        return memo[soupA][soupB] = total * 0.25;
    }
}
