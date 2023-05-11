class Solution {
  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

    int arrows = 1;
    int xStart, xEnd, firstEnd = points[0][1];
    for (int[] p : points) {
      xStart = p[0];
      xEnd = p[1];

      if (firstEnd < xStart) {
        arrows++;
        firstEnd = xEnd;
      }
    }
    return arrows;
  }
}
