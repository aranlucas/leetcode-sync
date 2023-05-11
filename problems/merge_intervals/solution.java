class Solution {
  public int[][] merge(int[][] intervals) {

    List<int[]> res = new ArrayList();

    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    res.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int[] prevInterval = res.get(res.size() - 1);
      if (isOverlap(intervals[i], prevInterval)) {
        // merge interval.
        // Pop latest rest, insert new interval

        int[] newInterval = mergeInterval(intervals[i], prevInterval);
        res.remove(res.size() - 1);
        res.add(newInterval);
      } else {
        res.add(intervals[i]);
      }
    }

    return res.toArray(new int[res.size()][]);
  }

  public boolean isOverlap(int[] a, int[] b) {
    return a[0] <= b[1] && b[0] <= a[1];
  }

  public int[] mergeInterval(int[] a, int[] b) {
    int start = Math.min(a[0], b[0]);
    int end = Math.max(a[1], b[1]);
    return new int[] {start, end};
  }
}
