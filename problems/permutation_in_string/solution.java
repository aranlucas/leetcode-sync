class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Count = new HashMap<>();

        for (char c : s1.toCharArray()) {
            s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> windowCount = new HashMap<>();

        int left = 0;
        int k = s1.length();
        for (int right = 0; right < s2.length(); right++) {
            char r = s2.charAt(right);
            windowCount.put(r, windowCount.getOrDefault(r, 0) + 1);
            
            while (right - left + 1 == k) {
                if (areEqual(s1Count, windowCount)) {
                    return true;
                }
                char l = s2.charAt(left);
                windowCount.put(l, windowCount.get(l) - 1);
                left++;
            }
        }

        return false;
    }
    
    private boolean areEqual(Map<Character, Integer> first, Map<Character, Integer> second) {
        return first.entrySet().stream().allMatch(e -> e.getValue().equals(second.get(e.getKey())));
    }
}