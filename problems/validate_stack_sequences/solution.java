class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int poppedIndex = 0;
        for (int i = 0; i < pushed.length; i++){
            if (stack.isEmpty() || stack.peek() != popped[poppedIndex]) {
                stack.push(pushed[i]);
            } 

            while (!stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            }
        }

        return stack.isEmpty();
    }
}