class Solution {
    public int numWays(int n, int k) {

        Integer[] memo = new Integer[n + 1];
        return solve(k, n, memo);
    }

    public int solve(int k, int n, Integer[] memo) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return k * k;
        }

        if (memo[n] != null) {
            return memo[n];
        }
        int paintPrev = (k - 1) * solve(k, n - 1, memo);

        int paint2Prev = (k -1) * solve(k, n - 2, memo);
        return memo[n] = paintPrev + paint2Prev;
    }
}