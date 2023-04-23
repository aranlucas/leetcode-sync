class Solution {
    record Pair(int row, int col){};

    public void setZeroes(int[][] matrix) {
        Deque<Pair> q = new ArrayDeque<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    Pair start = new Pair(i, j);
                    q.add(start);
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();
            matrix[cur.row][cur.col] = 0;

            for (int row = 0; row < matrix.length; row++) {
                matrix[row][cur.col] = 0;
            }
            
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[cur.row][col] = 0;
            }
        }
    }
}