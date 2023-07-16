class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Deque<int[]> merged = new ArrayDeque<>();
        merged.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] last = merged.getLast();

            // interval end time less than new interval start - no overlap
            if (last[1] < interval[0]) {
                merged.addLast(interval);
            } else {
                // update end time to new end time
                merged.getLast()[1] = Math.max(last[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
