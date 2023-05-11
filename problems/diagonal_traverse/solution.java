class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        // 1x1 = 1, 2x2 = 3, 3x3 = 5, 4x4 = 7

        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[n * m];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<>();

        for (int diagonal = 0; diagonal < n + m - 1; diagonal++) {
            intermediate.clear();
            int r = diagonal < m ? 0 : diagonal - m + 1;
            int c = diagonal < m ? diagonal : m - 1;

            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (r < n && c >= 0) {

                intermediate.add(mat[r][c]);
                ++r;
                --c;
            }

            if (diagonal % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }

        return result;
    }
}
