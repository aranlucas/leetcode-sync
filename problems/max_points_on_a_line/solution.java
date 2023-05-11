class Solution {
  public int maxPoints(int[][] points) {
    int max = 0;

    for (int[] p1 : points) {
      Map<Double, Integer> map = new HashMap<>();

      for (int[] p2 : points) {
        // Skip if same
        if (p1 == p2) {
          continue;
        }

        // Calculate slope

        double slope = 0;

        // Check if vertically aligned to avoid dividing by 0
        if (p2[0] - p1[0] == 0) {
          slope = Double.NEGATIVE_INFINITY;
        } else {
          slope = (p2[1] - p1[1]) / (double) (p2[0] - p1[0]);
        }

        map.put(slope, map.getOrDefault(slope, 0) + 1);
        max = Math.max(max, map.get(slope));
      }
    }

    return max + 1;
  }
}
