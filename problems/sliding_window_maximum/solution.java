class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] ans = new int[nums.length - k + 1];

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
      int currentNum = nums[windowEnd];

      pq.add(new int[] {nums[windowEnd], windowEnd});

      if (windowEnd - windowStart + 1 == k) {
        int[] max = pq.peek();
        while (!pq.isEmpty() && max[1] < windowStart) {
          pq.poll();
          max = pq.peek();
        }
        ans[windowStart] = max[0];
        windowStart++;
      }
    }
    return ans;
  }
}
