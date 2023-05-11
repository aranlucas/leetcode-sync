class Solution {
    public int minFlipsMonoIncr(String s) {
        int oneCount = 0;
        int solution = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                oneCount++;
            } else {
                solution = Math.min(oneCount, 1 + solution);
            }
        }

        return solution;
    }
}
