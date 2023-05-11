class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Count = new HashMap();

        for (char c : s1.toCharArray()) {
            s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowCount = new HashMap();

        // Fixed window size problem
        int k = s1.length();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s2.length(); windowEnd++) {
            char r = s2.charAt(windowEnd);
            windowCount.put(r, windowCount.getOrDefault(r, 0) + 1);

            // Window size is what we want, start moving left
            if (windowEnd - windowStart + 1 == k) {
                // Before removing windowStart, check if maps are equal
                if (areEqual(s1Count, windowCount)) {
                    return true;
                }
                char l = s2.charAt(windowStart);
                windowCount.put(l, windowCount.getOrDefault(l, 0) - 1);
                windowStart++;
            }
        }

        return false;
    }

    private boolean areEqual(Map<Character, Integer> first, Map<Character, Integer> second) {
        return first.entrySet().stream().allMatch(e -> e.getValue().equals(second.get(e.getKey())));
    }
}
