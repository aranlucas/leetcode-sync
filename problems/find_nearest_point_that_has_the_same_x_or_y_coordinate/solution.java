class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {

        int distance = Integer.MAX_VALUE;
        int answer = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (x == point[0] || y == point[1]) {
                int curDistance = calculateDistance(x, y, point);
                if (curDistance < distance) {
                    distance = curDistance;
                    answer = i;
                }
            }
        }

        return answer;
    }

    private int calculateDistance(int x, int y, int[] point) {
        return Math.abs(x - point[0]) + Math.abs(y - point[1]);
    }
}
