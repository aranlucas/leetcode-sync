class Solution {
    private Map<Character, String> digitToChar =
            Map.of(
                    '2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8',
                    "tuv", '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        // If the input is empty, immediately return an empty answer array
        if (digits.length() == 0) {
            return result;
        }

        StringBuilder current = new StringBuilder();
        backtrack(0, digits, current, result);

        return result;
    }

    public void backtrack(int start, String digits, StringBuilder current, List<String> result) {
        if (current.length() == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Add current candidates - All letters in map associated with number
        String possibleLetters = digitToChar.get(digits.charAt(start));
        for (char c : possibleLetters.toCharArray()) {
            // Add current candidate
            current.append(c);
            backtrack(start + 1, digits, current, result);
            // Remove current candidate
            current.deleteCharAt(current.length() - 1);
        }
    }
}
