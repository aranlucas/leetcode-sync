class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) {
            return 1;
        }
        Stack<Double> stack = new Stack<>();
        // [pos, speed]
        int[][] combine = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < combine.length; i++) {
            double currentTime = (double) (target - combine[i][0]) / combine[i][1];
            while (!stack.isEmpty() && stack.peek() <= currentTime) {
                stack.pop();
            }
            stack.push(currentTime);
        }

        return stack.size();
    }
}
