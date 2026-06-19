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
    public void reorderList(ListNode head) {

        
        ListNode slow = head;
        ListNode fast = head;

        // PART 1: get 2nd half
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;   // break the link

        // PART 2: reverse 2nd half
        ListNode prev = null;
        ListNode curr = secondHalf;


        while(curr!=null ){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        secondHalf = prev;



        // PART 3: insert between nodes
while (secondHalf != null) {
        ListNode nextSecond = secondHalf.next;  
            ListNode temp = head.next;
            head.next = secondHalf;
            head = head.next;
            head.next = temp;
            head = head.next;
            secondHalf = nextSecond;

        }      


    }
}