class Solution {
    Map<Character, Character> p = Map.of(
        '}', '{',
        ']', '[',
        ')', '('
    );

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (p.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != p.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}