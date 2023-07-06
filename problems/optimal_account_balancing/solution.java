class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> creditMap = new HashMap<>();
        for (int[] t : transactions) {
            creditMap.put(t[0], creditMap.getOrDefault(t[0], 0) + t[2]);
            creditMap.put(t[1], creditMap.getOrDefault(t[1], 0) - t[2]);
        }

        List<Integer> creditList = new ArrayList<>();

        for (int amount : creditMap.values()) {
            if (amount != 0) {
                creditList.add(amount);
            }
        }

        int n = creditList.size();

        return dfs(0, n, creditList);
    }

    public int dfs(int cur, int n, List<Integer> creditList) {
        while (cur < n && creditList.get(cur) == 0) {
            cur++;
        }

        if (cur == n) {
            return 0;
        }

        int cost = Integer.MAX_VALUE;

        for (int nei = cur + 1; nei < n; nei++) {
            if (creditList.get(nei) * creditList.get(cur) < 0) {
                creditList.set(nei, creditList.get(nei) + creditList.get(cur));
                cost = Math.min(cost, 1 + dfs(cur + 1, n, creditList));
                creditList.set(nei, creditList.get(nei) - creditList.get(cur));
            }
        }

        return cost;
    }
}