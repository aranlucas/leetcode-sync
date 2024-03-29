class State {
    /**
     * data object to keep the state info for each step:
     */
    public int x, y, distance, k;

    public State(int x, int y, int distance, int k) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.k = k;
    }

    @Override
    public int hashCode() {
        // needed when we put objects into any container class
        return (this.x + 1) * (this.y + 1) * this.k;
    }

    @Override
    public boolean equals(Object other) {
        /**
         * only (row, col, k) matters as the state info
         */
        if (!(other instanceof State)) {
            return false;
        }
        State newState = (State) other;
        return (this.x == newState.x) && (this.y == newState.y) && (this.k == newState.k);
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", this.x, this.y, this.k);
    }
}

class Solution {

    int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        // if we have sufficient quotas to eliminate the obstacles in the worst case,
        // then the shortest distance is the Manhattan distance.
        if (k >= m + n - 2) {
            return m + n - 2;
        }

        Deque<State> q = new LinkedList<>();
        HashSet<State> seen = new HashSet<>();

        State first = new State(0, 0, 0, k);
        q.addLast(first);
        seen.add(first);

        while (!q.isEmpty()) {
            State cur = q.pollFirst();

            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur.distance;
            }

            for (int[] dir : DIRS) {
                int dx = cur.x + dir[0];
                int dy = cur.y + dir[1];

                if (0 <= dx && dx < n && 0 <= dy && dy < m) {
                    int nextElimination = cur.k - grid[dx][dy];
                    State newState = new State(dx, dy, cur.distance + 1, nextElimination);
                    if (nextElimination >= 0 && !seen.contains(newState)) {
                        seen.add(newState);
                        q.addLast(newState);
                    }
                }
            }
        }

        return -1;
    }
}
