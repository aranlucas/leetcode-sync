class Solution {
    record Record(Character name, int[] votes) {}

    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        int l = votes[0].length();

        for (String vote : votes) {

            char[] voteChar = vote.toCharArray();

            for (int i = 0; i < voteChar.length; i++) {
                char c = voteChar[i];

                if (!map.containsKey(c)) {
                    int[] voteArray = new int[voteChar.length];
                    map.put(c, voteArray);
                }
                int[] v = map.get(c);
                v[i] += 1;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(
                list,
                (a, b) -> {
                    for (int i = 0; i < l; i++) {
                        if (map.get(a)[i] != map.get(b)[i]) {
                            return map.get(b)[i] - map.get(a)[i];
                        }
                    }
                    return a - b;
                });

        StringBuilder sb = new StringBuilder();

        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
