class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(n - 1 - i) - 'A' + 1;
            result += (Math.pow(26, i)) * c;
        }
        return result;
    }
}