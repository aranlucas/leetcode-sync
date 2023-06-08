class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[][] memo = new double[n][target + 1];

        for (double[] row : memo) {
            Arrays.fill(row, -1);
        }

        return findProbability(0, n, memo, prob, target);
    }

    public double findProbability(int index, int n, double[][] memo, double[] prob, int target) {
        if (target < 0) {
            return 0;
        }

        if (index == n) {
            return target == 0 ? 1 : 0;
        }

        if (memo[index][target] != -1) {
            return memo[index][target];
        }

        double prob1 = findProbability(index + 1, n, memo, prob, target - 1) * prob[index];
        double prob2 = findProbability(index + 1, n, memo, prob, target) * (1 - prob[index]);
        return memo[index][target] = prob1 + prob2;
    }
}
