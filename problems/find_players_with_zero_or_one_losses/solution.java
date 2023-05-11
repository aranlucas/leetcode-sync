class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        Set<Integer> seen = new HashSet<>();
        Map<Integer, Integer> lossesCount = new HashMap<>();

        for (int i = 0; i < matches.length; i++) {
            int[] match = matches[i];
            int winner = match[0];
            int loser = match[1];

            seen.add(match[0]);
            seen.add(match[1]);
            lossesCount.put(loser, lossesCount.getOrDefault(loser, 0) + 1);
        }

        List<List<Integer>> answer = Arrays.asList(new ArrayList<>(), new ArrayList<>());

        for (int player : seen) {
            if (!lossesCount.containsKey(player)) {
                answer.get(0).add(player);
            } else if (lossesCount.get(player) == 1) {
                answer.get(1).add(player);
            }
        }

        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));

        return answer;
    }
}
