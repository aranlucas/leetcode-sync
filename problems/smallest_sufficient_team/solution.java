class Solution {
    public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
        int n = people.size();
        int m = reqSkills.length;
        HashMap<String, Integer> skillIndex = new HashMap<>();

        for (int i = 0; i < m; i++) {
            skillIndex.put(reqSkills[i], i);
        }

        int[] skillsMaskOfPerson = new int[n];
        for (int i = 0; i < n; i++) {
            for (String skill : people.get(i)) {
                skillsMaskOfPerson[i] |= 1 << skillIndex.get(skill);
            }
        }
        long[] dp = new long[1 << m];
        Arrays.fill(dp, (1L << n) - 1);

        dp[0] = 0;

        for (int skillsMask = 1; skillsMask < (1 <<m); skillsMask++) {
            for (int i = 0; i < n; i++) {
                int smallerSkillsMask = skillsMask & ~skillsMaskOfPerson[i];
                if (smallerSkillsMask != skillsMask) {
                    long peopleMask = dp[smallerSkillsMask] | (1L << i);
                    if (Long.bitCount(peopleMask) < Long.bitCount(dp[skillsMask])) {
                        dp[skillsMask] = peopleMask;
                    }
                }
            }
        }
        long answerMask = dp[(1 << m) - 1];
        int ans[] = new int [Long.bitCount(answerMask)];
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (((answerMask >> i) & 1) == 1) {
                ans[ptr++] = i;
            }
        }
        return ans;
    }
}