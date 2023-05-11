class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        // [age, score]
        List<int[]> teamScorepair = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            teamScorepair.add(new int[] {ages[i], scores[i]});
        }

        // Sort in ascending order of age and then by score.
        Collections.sort(teamScorepair, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // initialize dp table
        int[] memo = new int[scores.length];
        Arrays.fill(memo, -1);

        int[] ans = new int[teamScorepair.size()];
        int best = 0;
        for (int i = 0; i < teamScorepair.size(); i++) {
            ans[i] = teamScorepair.get(i)[1];
            for (int j = 0; j < i; j++) {
                if (teamScorepair.get(i)[1] >= teamScorepair.get(j)[1]) {
                    ans[i] = Math.max(ans[i], ans[j] + teamScorepair.get(i)[1]);
                }
            }
            best = Math.max(best, ans[i]);
        }
        return best;
    }
}
