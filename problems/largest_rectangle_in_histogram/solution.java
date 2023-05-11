class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int start;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];
            start = i;

            while (!stack.isEmpty() && stack.peek().getValue() > currentHeight) {
                var pair = stack.pop();
                int index = pair.getKey();
                int h = pair.getValue();
                maxArea = Math.max(maxArea, h * (i - index));
                start = index;
            }
            stack.push(new Pair(start, currentHeight));
        }

        while (!stack.isEmpty()) {
            var pair = stack.pop();
            int index = pair.getKey();
            int h = pair.getValue();
            maxArea = Math.max(maxArea, h * (heights.length - index));
        }

        return maxArea;
    }
}
