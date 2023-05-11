class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> p = new HashMap<>();
        p.put('}', '{');
        p.put(']', '[');
        p.put(')', '(');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (p.containsKey(c)) {
                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                // If the mapping for this bracket doesn't match the stack's top element, return
                // false.
                if (topElement != p.get(c)) {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }

        return stack.isEmpty();
    }
}
