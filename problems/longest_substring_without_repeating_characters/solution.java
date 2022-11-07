class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> windowCount = new HashMap();
        int longestString = 0;
        
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            char rightChar = s.charAt(windowEnd);
            windowCount.put(rightChar, windowCount.getOrDefault(rightChar, 0) + 1);
            
            // Check when window needs to shrink. If window is expected to shrink multiple times, use while loop, otherwise if condition
            while (windowCount.get(rightChar) > 1){
                char leftChar = s.charAt(windowStart);
                windowCount.put(leftChar, windowCount.getOrDefault(leftChar, 0) - 1);
                windowStart++;  
            }
            
            longestString = Math.max(longestString, windowEnd-windowStart + 1);
        }

        return longestString;
    }
}