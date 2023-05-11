class Solution {
    public String predictPartyVictory(String senate) {

        Deque<Character> q = new ArrayDeque<>();
        int d = 0;
        int r = 0;

        // Floating Ban Count
        int dFloatingBan = 0, rFloatingBan = 0;

        for (char c : senate.toCharArray()) {
            if (c == 'D') {
                d++;
            } else {
                r++;
            }
            q.add(c);
        }

        while (d > 0 && r > 0) {
            char curr = q.pop();

            if (curr == 'D') {
                if (dFloatingBan > 0) {
                    dFloatingBan--;
                    d--;
                } else {
                    rFloatingBan++;
                    q.add('D');
                }
            } else {
                if (rFloatingBan > 0) {
                    rFloatingBan--;
                    r--;
                } else {
                    dFloatingBan++;
                    q.add('R');
                }
            }
        }

        return r > 0 ? "Radiant" : "Dire";
    }
}
