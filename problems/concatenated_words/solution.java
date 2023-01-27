class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(words));
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            int length = word.length();
            boolean[] dp = new boolean[length + 1];
            dp[0] = true;
            for (int i = 1; i <= length; i++) {
                int t = i == length ? 1 : 0;
                for (int j = i - 1; j >= t; j--) {
                    if (dp[j] && dictionary.contains(word.substring(j, i))) {
                        dp[i] = true;
                    }
                }
            }
            if (dp[length]) {
                answer.add(word);
            }
        }
        return answer;   
    }
}