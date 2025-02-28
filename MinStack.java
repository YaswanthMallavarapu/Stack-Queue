class MinStack {
    Stack<Integer> minstack;
    Stack<Integer> stack;

    public MinStack() {
        minstack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            minstack.push(val);
        } else {
            if (minstack.peek() >= val) {
                minstack.push(val);
            }
            stack.push(val);
        }
    }

    public void pop() {
        int popped = stack.pop();
        if (minstack.peek() == popped) {
            minstack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */