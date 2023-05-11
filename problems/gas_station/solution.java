class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        int curr = 0;
        int start = 0;
        for (int i = 0; i < n; ++i) {
            int distance = gas[i] - cost[i];
            total += distance;
            curr += distance;
            // If one couldn't get here,
            if (curr < 0) {
                // Pick up the next station as the starting one.
                start = i + 1;
                // Start with an empty tank.
                curr = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
