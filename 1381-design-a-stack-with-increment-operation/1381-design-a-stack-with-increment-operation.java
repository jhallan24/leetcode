class CustomStack {
    private int[] stack;
    private int[] incremental;
    private int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        incremental = new int[maxSize];
        top = -1;
        
    }
    
    public void push(int x) {
        if (top < stack.length - 1) {
            top++;
            stack[top] = x;
        }
        
    }
    
    public int pop() {
        if (top == -1) {
            return -1;
        }
        int result = stack[top] + incremental[top];
        if (top > 0) {
            incremental[top - 1] += incremental[top]; // Pass increment to the next element
        }
        incremental[top] = 0; // Reset increment for the popped element
        top--;
        return result;
        
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k, top + 1) - 1;
        if (limit >= 0) {
            incremental[limit] += val;
        
    }
}
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

    
