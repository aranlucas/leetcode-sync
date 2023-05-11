class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        int l = 0;

        int answer = 0;
        int curr = 0;
        for (int r = 0; r < s.length(); r++) {
            if (vowels.contains(s.charAt(r))) {
                curr++;
            }

            // Window is broken if window size is greater than k. Remove chars
            while (r - l + 1 > k) {
                if (vowels.contains(s.charAt(l))) {
                    curr--;
                }
                l++;
            }
            answer = Math.max(answer, curr);
        }

        return answer;
    }
}
