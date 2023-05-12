class Solution {
    public long mostPoints(int[][] questions) {
        Long[] memo = new Long[questions.length];
        return solve(0, questions, memo);
    }

    public long solve(int index, int[][] questions, Long[] memo) {
        if (index > questions.length - 1) {
            return 0;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        int[] question = questions[index];
        int points = question[0];
        int brainpower = question[1];

        long solveProblem = points + solve(index + brainpower + 1, questions, memo);
        long skipProblem = solve(index + 1, questions, memo);
        return memo[index] = Math.max(solveProblem, skipProblem);
    }
}
