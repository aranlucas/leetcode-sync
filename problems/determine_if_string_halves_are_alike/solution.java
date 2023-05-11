class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            for (char c : vowels.toCharArray()) {
                if (s.charAt(i) == c) {
                    count++;
                }
            }
        }

        for (int i = n / 2; i < n; i++) {
            for (char c : vowels.toCharArray()) {
                if (s.charAt(i) == c) {
                    count--;
                }
            }
        }

        return count == 0;
    }
}
