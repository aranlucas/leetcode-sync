class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestSubstring = 0;
        
        Map<Character, Integer> map = new HashMap();
        
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char c = s.charAt(windowEnd);
            
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while (map.get(c) > 1) {
                char left = s.charAt(windowStart);
                map.put(left, map.getOrDefault(left, 0) - 1);
                windowStart++;
            }
            
            
            longestSubstring = Math.max(longestSubstring, windowEnd - windowStart + 1);
        }
        return longestSubstring;
    }
}