class MyStack {
    Integer top;
    Queue<Integer> q;
    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList();
        top = null;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty())
            return -1;
        
        int size = q.size()-1;
        
        while(size != 0){
            if(size == 1){
                top = q.remove();
                q.add(top);
            }
            else    
                q.add(q.remove());
            size--;
        }
        
        return q.remove();
    }
    
    /** Get the top element. */
    public int top() {
        if(empty())
            return -1;
        
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */