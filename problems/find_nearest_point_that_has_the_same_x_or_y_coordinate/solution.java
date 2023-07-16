class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int answer = -1;

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (x == point[0] || y == point[1]) {
                int distance = calculateDistance(x, y, point[0], point[1]);

                if (distance < min) {
                    min = distance;
                    answer = i;
                }
            }
        }

        return answer;
    }

    public int calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
