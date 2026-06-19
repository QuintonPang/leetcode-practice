/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */ 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode back = new ListNode(0);
        back.next = head;
        ListNode front = back;
        ListNode dummy = back;

        

        for(int i = 0; i< n ;i++){
            front = front.next;
        }

        while(front.next!=null){
            back = back.next;
            front = front.next;
        }
        back.next = back.next.next;
         return dummy.next;

    }

}