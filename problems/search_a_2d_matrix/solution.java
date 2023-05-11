class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length * matrix[0].length - 1;

        while (lo <= hi) {
            int mid = lo + hi >> 1;

            // [x, y]
            int[] coord = getCoord(mid, matrix);

            if (matrix[coord[0]][coord[1]] == target) {
                return true;
            } else if (matrix[coord[0]][coord[1]] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }

    private int[] getCoord(int index, int[][] matrix) {
        int width = matrix[0].length;

        int y = index % width;
        int x = index / width;
        return new int[] {x, y};
    }
}
