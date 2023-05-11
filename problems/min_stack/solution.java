class MinStack {

  Deque<int[]> stack;

  public MinStack() {
    stack = new ArrayDeque<int[]>();
  }

  public void push(int val) {
    if (stack.isEmpty()) {
      stack.push(new int[] {val, val});
      return;
    }

    int currentMin = stack.peek()[1];
    stack.push(new int[] {val, Math.min(val, currentMin)});
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek()[0];
  }

  public int getMin() {
    return stack.peek()[1];
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
 * obj.push(val); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
 */
