class Solution {
    int[][] DIRS = {{0,1}, {1,0}, {0,-1}, {-1, 0}};

    record State(int keys, int i, int j) {
        public String toString(){
            return keys + " " + i + " " + j;
        }
    }

    public int shortestPathAllKeys(String[] grid) {
        int x = -1;
        int y = -1;
        int m = grid.length;
        int n = grid[0].length();
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);

                // Starting point
                if (c == '@') {
                    x = i;
                    y = j;
                }

                if (isKey(c)) {
                    max++;
                }
            }
        }

        State start = new State(0, x, y);
        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(start.toString());
        q.offer(start);
        int step = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                State cur = q.poll();

                if (cur.keys == (1 << max) - 1) {
                    return step;
                }

                for (int[] dir: DIRS) {
                    int dx = cur.i + dir[0];
                    int dy = cur.j + dir[1];
                    int keys = cur.keys;

                    if (dx >= 0 && dx < m && dy >= 0 && dy < n) {
                        char c = grid[dx].charAt(dy);

                        // Wall
                        if (c == '#') {
                            continue;
                        }

                        if (isKey(c)) {
                            keys |= 1 << (c - 'a');
                        }

                        if (isLock(c) && ((keys >> (c - 'A')) & 1) == 0) {
                            continue;
                        }
                        State nei = new State(keys, dx, dy);

                        if (!visited.contains(nei.toString())) {
                            q.offer(nei);
                            visited.add(nei.toString());
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private boolean isLock(char c) {
        return c >= 'A' && c <= 'F';
    }

    private boolean isKey(char c) {
        return c >= 'a' && c <= 'f';
    }
}