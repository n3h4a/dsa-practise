class MyStack {
    private final Queue<Integer> q = new ArrayDeque<>();

    public MyStack() {}

    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) q.add(q.poll());  // rotate x to the front
    }

    public int pop() { return q.poll(); }

    public int top() { return q.peek(); }

    public boolean empty() { return q.isEmpty(); }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */