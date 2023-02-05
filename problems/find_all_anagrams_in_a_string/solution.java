class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pCount = new HashMap<>();

        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> windowCount = new HashMap<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            windowCount.put(r, windowCount.getOrDefault(r, 0) + 1);
            while (right - left + 1 == p.length()) {
                System.out.println(windowCount);
                if (areEqual(pCount, windowCount)) {
                    answer.add(left);
                }
                char l = s.charAt(left);
                windowCount.put(l, windowCount.getOrDefault(l, 0) - 1);
                left++;
            }
        }

        return answer;
    }
    
    private boolean areEqual(Map<Character, Integer> first, Map<Character, Integer> second) {
        return first.entrySet().stream().allMatch(e -> e.getValue().equals(second.get(e.getKey())));
    }
}