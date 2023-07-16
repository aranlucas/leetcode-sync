class Solution {
    // Returns the delta Y.
    int getYDiff(int[] a, int[] b) {
        return a[1] - b[1];
    }

    // Returns the delta X.
    int getXDiff(int[] a, int[] b) {
        return a[0] - b[0];
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int[] a = coordinates[0];
        int[] b = coordinates[1];
        int deltaY = getYDiff(b, a);
        int deltaX = getXDiff(b, a);

        for (int i = 2; i < coordinates.length; i++) {
            int[] c = coordinates[i];

            if (deltaY * getXDiff(c, a) != deltaX * getYDiff(c, a)) {
                return false;
            }
        }

        return true;
    }
}
