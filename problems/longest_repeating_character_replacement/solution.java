class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int maxFreq = 0;
        int left = 0;
        int longestSubstringLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);

            map.put(r, map.getOrDefault(r, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(r));

            while (right - left + 1 - maxFreq > k) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                left++;
            }

            longestSubstringLength = Math.max(right - left + 1, longestSubstringLength);
        }

        return longestSubstringLength;
    }
}