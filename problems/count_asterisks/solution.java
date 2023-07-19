class Solution {
    public int countAsterisks(String s) {
        int res = 0; 
        int bars = 0;

        for (char c : s.toCharArray()) {
            if (c == '*' && bars % 2 == 0) {
                res++;
            }

            if (c == '|') {
                bars++;
            }
        }
        return res;
    }
}