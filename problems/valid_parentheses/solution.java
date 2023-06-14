class Solution {

    Map<Character, Character> matching = Map.of(
        '}', '{',
        ')', '(',
        ']', '['
    );

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && matching.containsKey(c)) {
                char match = stack.pop();

                if (match != matching.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}