class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {

        Map<Character, Integer> count = new HashMap<>();
        int maxFreq = 0;
        int left = 0;

        int consecutive = 0;
        for (int right = 0; right < answerKey.length(); right++) {
            char r = answerKey.charAt(right);

            count.put(r, count.getOrDefault(r, 0) + 1);

            maxFreq = Math.max(count.get(r), maxFreq);

            while (right - left + 1 - maxFreq > k) {
                char l = answerKey.charAt(left);
                count.put(l, count.get(l) - 1);
                left++;
            }
            consecutive = Math.max(consecutive, right - left + 1);
        }

        return consecutive;
    }
}
