class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {

            int asteroid = asteroids[i];

            // Only push asteroids going right
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                // Clear smaller asteroids if going left if previous one is going right
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
                if (stack.peek() == -asteroid) {
                    // Pop if same but negative
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
