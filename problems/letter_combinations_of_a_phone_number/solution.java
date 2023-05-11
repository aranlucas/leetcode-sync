class Solution {
    Map<Character, List<Character>> charToLetter = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        charToLetter.put('1', new ArrayList<>());
        charToLetter.put('2', List.of('a', 'b', 'c'));
        charToLetter.put('3', List.of('d', 'e', 'f'));
        charToLetter.put('4', List.of('g', 'h', 'i'));
        charToLetter.put('5', List.of('j', 'k', 'l'));
        charToLetter.put('6', List.of('m', 'n', 'o'));
        charToLetter.put('7', List.of('p', 'q', 'r', 's'));
        charToLetter.put('8', List.of('t', 'u', 'v'));
        charToLetter.put('9', List.of('w', 'x', 'y', 'z'));
        charToLetter.put('0', new ArrayList<>());

        List<String> answer = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        backtrack(0, answer, digits, curr);
        return answer;
    }

    private void backtrack(int index, List<String> answer, String digits, StringBuilder curr) {
        // Are we done?
        if (index >= digits.length()) {
            answer.add(curr.toString());
            return;
        }

        // What are the candidates?
        for (char candidate : charToLetter.get(digits.charAt(index))) {
            curr.append(candidate);
            backtrack(index + 1, answer, digits, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
