/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
       
       // Pass 1:interleave
       Node curr = head;
       while(curr!=null){
        Node clone = new Node(curr.val);
        clone.next = curr.next;
        curr.next = clone;
        curr = clone.next;
       }

       // Pass 2: assign random
       curr = head;
       while(curr!=null){
        curr.next.random = curr.random!=null?curr.random.next:null; // get cloned
        curr = curr.next.next; // jump to next original node
       }

       // Pass 3: separate
       curr = head;
       Node clonedHead = head.next;
       while(curr!=null){
        Node clone = curr.next;
        curr.next = clone.next;
        clone.next = clone.next != null ? clone.next.next : null;
        curr = curr.next;
       }

       return clonedHead;
    }
}