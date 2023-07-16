class Solution {
    int MODULO = 1000000007;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        Integer[][] memo = new Integer[locations.length][fuel + 1];
        return solve(locations, start, finish, fuel, memo);
    }

    public int solve(int[] locations, int currCity, int finish, int fuel, Integer[][] memo) {
        if (fuel < 0) {
            return 0;
        }

        if (memo[currCity][fuel] != null) {
            return memo[currCity][fuel];
        }

        int answer = 0;
        if (currCity == finish) {
            answer = 1;
        }
        for (int i = 0; i < locations.length; i++) {
            if (i != currCity) {
                answer =
                        (answer
                                        + solve(
                                                locations,
                                                i,
                                                finish,
                                                fuel - Math.abs(locations[i] - locations[currCity]),
                                                memo))
                                % MODULO;
            }
        }

        return memo[currCity][fuel] = answer;
    }
}
