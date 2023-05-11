class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        Map<String, BiFunction<Integer, Integer, Integer>> operation = new HashMap<>();
        operation.put("+", (a, b) -> a + b);
        operation.put("-", (a, b) -> a - b);
        operation.put("*", (a, b) -> a * b);
        operation.put("/", (a, b) -> a / b);

        for (String c : tokens) {
            // Do operation
            if (operation.containsKey(c)) {
                var func = operation.get(c);
                int a = stack.pop();
                int b = stack.pop();
                int result = func.apply(b, a);
                stack.push(result);
            } else {
                stack.add(Integer.parseInt(c));
            }
        }

        return stack.pop();
    }
}
