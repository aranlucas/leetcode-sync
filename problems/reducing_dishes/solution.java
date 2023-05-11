class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        Integer[][] memo = new Integer[satisfaction.length + 1][satisfaction.length + 1];

        return solve(0, 1, satisfaction, memo);
    }

    public int solve(int index, int time, int[] satisfaction, Integer[][] memo) {
        if (index == satisfaction.length) {
            return 0;
        }

        if (memo[index][time] != null) {
            return memo[index][time];
        }
        int cook = satisfaction[index] * time + solve(index + 1, time + 1, satisfaction, memo);
        int noCook = solve(index + 1, time, satisfaction, memo);

        return memo[index][time] = Math.max(cook, noCook);
    }
}
