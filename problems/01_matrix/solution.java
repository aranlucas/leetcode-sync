class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] matrix = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = mat[i][j];
                if (mat[i][j] == 0) {
                    q.offer(new int[] {i, j});
                    seen[i][j] = true;
                }
            }
        }

        int level = 1;
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] state = q.poll();
                int r = state[0];
                int c = state[1];
                for (int[] direction : directions) {
                    int dx = r + direction[0];
                    int dy = c + direction[1];

                    if (valid(dx, dy, mat) && !seen[dx][dy]) {
                        seen[dx][dy] = true;
                        matrix[dx][dy] = level;
                        q.offer(new int[] {dx, dy});
                    }
                }
            }
            level++;
        }

        return matrix;
    }

    public boolean valid(int row, int col, int[][] mat) {
        return 0 <= row && row < mat.length && 0 <= col && col < mat[0].length;
    }
}
