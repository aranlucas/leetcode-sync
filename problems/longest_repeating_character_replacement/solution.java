class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int answer = 0;
        int maxFreq = 0;
        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0) + 1);
            maxFreq = Math.max(map.get(r), maxFreq);

            while (right - left + 1 - maxFreq > k) {
                char l = s.charAt(left);
                map.put(l, map.getOrDefault(l, 0) - 1);
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}