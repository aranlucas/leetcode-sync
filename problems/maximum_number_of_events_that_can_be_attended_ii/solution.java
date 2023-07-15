class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        Integer[][] memo = new Integer[events.length + 1][k + 1];
        return solve(0, events, k, memo);
    }

    public int solve(int pos, int[][] events, int k, Integer[][] memo) {
        if (pos == events.length) {
            return 0;
        }

        if (k == 0) {
            return 0;
        }

        if (memo[pos][k] != null) {
            return memo[pos][k];
        }

        int skip = solve(pos + 1, events, k, memo);

        int nextEvent = bisectRight(events, events[pos][1]);

        int take = events[pos][2] + solve(nextEvent, events, k - 1, memo);
        
        return memo[pos][k] = Math.max(take, skip);
    }

    public int bisectRight(int[][] events, int target) {
        int left = 0;
        int right = events.length;


        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}