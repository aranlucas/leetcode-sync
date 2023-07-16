class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> ts = new TreeSet<Integer>();
        Map<Pair<Integer, Integer>, Integer> dp = new HashMap<>();

        for (int i : arr2) {
            ts.add(i);
        }

        int answer = solve(0, -1, arr1, ts, dp);

        return answer < 2_001 ? answer : -1;
    }

    public int solve(
            int i,
            int prev,
            int[] arr1,
            TreeSet<Integer> ts,
            Map<Pair<Integer, Integer>, Integer> dp) {
        if (i == arr1.length) {
            return 0;
        }

        if (dp.containsKey(new Pair<>(i, prev))) {
            return dp.get(new Pair<>(i, prev));
        }

        int cost = 2_001;

        if (arr1[i] > prev) {
            cost = solve(i + 1, arr1[i], arr1, ts, dp);
        }

        Integer curr = ts.higher(prev);

        if (curr != null) {
            cost = Math.min(cost, 1 + solve(i + 1, curr, arr1, ts, dp));
        }
        dp.put(new Pair<>(i, prev), cost);

        return cost;
    }
}
