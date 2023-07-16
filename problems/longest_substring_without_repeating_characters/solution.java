class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> sCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowCount = new HashMap<>();

        int longestSubstring = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            while (windowCount.get(c) > 1) {
                char l = s.charAt(left);
                windowCount.put(l, windowCount.get(l) - 1);
                left++;
            }

            longestSubstring = Math.max(longestSubstring, right - left + 1);
        }

        return longestSubstring;
    }
}
