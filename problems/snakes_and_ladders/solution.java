class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n * n + 1];
        int label = 1;
        Integer[] columns = new Integer[n];

        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }

        for (int row = n - 1; row >= 0; row--) {
            for (int column : columns) {
                cells[label++] = new Pair<>(row, column);
            }
            Collections.reverse(Arrays.asList(columns));
        }

        // System.out.println(Arrays.deepToString(cells));

        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                Pair<Integer, Integer> cell = cells[next];
                int row = cell.getKey();
                int column = cell.getValue();
                int destination = board[row][column];
                if (destination == -1) {
                    destination = next;
                }

                if (dist[destination] == -1) {
                    dist[destination] = dist[curr] + 1;
                    q.add(destination);
                }
            }
        }
        return dist[n * n];
    }
}