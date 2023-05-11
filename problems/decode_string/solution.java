class Solution {
    public String decodeString(String s) {

        Deque<Character> stack = new ArrayDeque();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            if (sChar == ']') {
                List<Character> intermediate = new ArrayList<>();

                while (stack.peekLast() != '[') {
                    intermediate.add(stack.removeLast());
                }

                stack.removeLast();

                int base = 1;
                int k = 0;
                // get the number k
                while (!stack.isEmpty() && Character.isDigit(stack.peekLast())) {
                    k = k + (stack.removeLast() - '0') * base;
                    base *= 10;
                }
                while (k != 0) {
                    for (int j = intermediate.size() - 1; j >= 0; j--) {
                        stack.addLast(intermediate.get(j));
                    }
                    k--;
                }
            } else {
                stack.addLast(sChar);
            }
        }

        // get the result from stack
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.removeLast();
        }
        return new String(result);
    }
}
