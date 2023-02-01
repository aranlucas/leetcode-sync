class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tCount = new HashMap<>();

        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        int required = tCount.size();
        String answer = "";
        int min = Integer.MAX_VALUE;
        int left = 0;
        Map<Character, Integer> windowCount = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            windowCount.put(r, windowCount.getOrDefault(r, 0) + 1);
            
            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (tCount.containsKey(r) && windowCount.get(r).intValue() == tCount.get(r).intValue()) {
                match++;
            }

            while (left <= right && match == required) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    answer = s.substring(left, right + 1);
                }
                char l = s.charAt(left);
                windowCount.put(l, windowCount.getOrDefault(l, 0) - 1);
                
                if (tCount.containsKey(l) && windowCount.get(l).intValue() < tCount.get(l).intValue()) {
                    match--;
                }
                left++;
            }
        }

        return answer;
    }
}