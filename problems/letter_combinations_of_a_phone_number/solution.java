class Solution {
    String[] KEYBOARD = {
        "", 
        "", 
        "abc", 
        "def", 
        "ghi", 
        "jkl", 
        "mno", 
        "pqrs", 
        "tuv", 
        "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        backtrack(0, digits, new StringBuilder(), result);

        return result;
    }

    private void backtrack(int index, String digits, StringBuilder current, List<String> result) {
        if (current.length() == digits.length()) {
            result.add(current.toString());
            return;
        }

        int c = digits.charAt(index) - '0';

        for (char candidate: KEYBOARD[c].toCharArray()) {
            current.append(candidate);
            backtrack(index + 1, digits, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}