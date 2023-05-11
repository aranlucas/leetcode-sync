class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int minRounds = 0;

        for (int value : map.values()) {
            // Not possible to complete
            if (value == 1) {
                return -1;
            }

            if (value % 3 == 0) {
                // Do 3 per round if you can;
                minRounds += value / 3;
            } else {
                minRounds += value / 3 + 1;
            }
        }

        return minRounds;
    }
}
