class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int windowCount = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while (map.get(c) > 1) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                left++;
            }

            windowCount = Math.max(windowCount, right-left +1);
        }


        return windowCount;
    }
}