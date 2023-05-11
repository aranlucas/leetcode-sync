class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> windowCount = new HashMap();

        int longestRepeating = 0;

        int max = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char r = s.charAt(windowEnd);
            windowCount.put(r, windowCount.getOrDefault(r, 0) + 1);

            max = Math.max(max, windowCount.get(r));
            int lettersToChange = (windowEnd - windowStart + 1) - max;
            if (lettersToChange > k) {
                char l = s.charAt(windowStart);
                windowCount.put(l, windowCount.getOrDefault(l, 0) - 1);
                windowStart++;
            }

            longestRepeating = Math.max(longestRepeating, windowEnd - windowStart + 1);
        }

        return longestRepeating;
    }
}
