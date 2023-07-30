class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();

        int[] arr = new int[26];

        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                ans += arr[i];
            }
        }

        return ans;
    }
}