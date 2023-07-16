class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                // 4 scenarios: 1.+ + 2.- - 3.+ - 4.- +
                // Collision only at + -

                // Scenario + - one is destroyed
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    // destroy the previous positive one(s)
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop();
                }
            }
        }

        int[] answer = new int[stack.size()];

        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            answer[i] = stack.pop();
            i--;
        }
        return answer;
    }
}
