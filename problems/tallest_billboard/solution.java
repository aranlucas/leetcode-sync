class Solution {
    Integer memo[][];

    public int tallestBillboard(int[] rods) {
        memo = new Integer[rods.length][10002];
        return solve(0, 0, rods);
    }

    public int solve(int diff, int index, int[] rods) {
        if (index >= rods.length) {
            if (diff == 0){
                return 0;
            }
            return Integer.MIN_VALUE;
        }

        if (memo[index][diff + 5001] != null){
            return memo[index][diff + 5001];
        }
        
        int currentRod = rods[index];
        int solveAddToLeft = currentRod + solve(diff + currentRod, index + 1, rods);
        int solveAddToRight = solve(diff - currentRod, index + 1, rods);
        int solveDontAdd = solve(diff, index + 1, rods);

        int answer = Math.max(solveAddToLeft, Math.max(solveAddToRight, solveDontAdd));
        memo[index][diff + 5001] = answer;
        return answer;
    }
}