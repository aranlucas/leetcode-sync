class Solution {
  public int[][] kClosest(int[][] points, int k) {

    PriorityQueue<int[]> pq =
        new PriorityQueue<int[]>(
            (a, b) -> {
              return (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]);
            });

    for (int i = 0; i < points.length; i++) {
      pq.offer(points[i]);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.toArray(new int[0][0]);
  }
}
