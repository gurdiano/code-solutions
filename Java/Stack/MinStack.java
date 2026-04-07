// https://neetcode.io/problems/minimum-stack

// O(1) for all operations
class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();       
    }
    
    public void push(int val) {
        stack.push(val);
        if (this.minStack.isEmpty() || val <= this.minStack.peek()) this.minStack.push(val);
    }
    
    public void pop() {
        if (this.stack.isEmpty()) return;
        int val = this.stack.pop();
        if(val == this.minStack.peek()) this.minStack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
