class MinStack {

    private Node head;

    public MinStack() {
        
    }
    
    public void push(int value) {
        int min = Integer.MAX_VALUE;
        if(head!=null) min = head.min;
        Node node = new Node(value, Math.min(min, value), head);
        head = node;
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

    private class Node{
        
        public int val;
        public int min;
        public Node next;
        Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
   
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */