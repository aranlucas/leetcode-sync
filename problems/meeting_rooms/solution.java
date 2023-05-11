class Solution {
  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals.length == 0) {
      return true;
    }

    // Min heap
    PriorityQueue<Integer> allocator = new PriorityQueue<Integer>();

    // Sort the intervals by start time
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    // Add the first meeting
    allocator.add(intervals[0][1]);

    // Iterate over remaining intervals
    for (int i = 1; i < intervals.length; i++) {
      if (allocator.peek() <= intervals[i][0]) {
        allocator.poll();
      }

      allocator.add(intervals[i][1]);
      if (allocator.size() > 1) {
        return false;
      }
    }

    // The size of the heap tells us the minimum rooms required for all the meetings.
    return allocator.size() == 1;
  }
}
