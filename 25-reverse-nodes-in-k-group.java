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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k ==1)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;
        ListNode groupLast = groupPrev;       
        while( groupLast !=null){
            

        int count =0;
        
        while(count<k&& groupLast!=null){
            groupLast = groupLast.next;
            count ++;
        }
        
        if(groupLast == null) break;
        
        // reverse
      
        ListNode curr = groupPrev.next;
        ListNode groupNext = groupLast.next;
        ListNode prev = groupNext;
        while(curr!=groupNext){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        ListNode temp = groupPrev.next;
        
        groupPrev.next = groupLast;
        groupPrev = temp;
        groupLast = groupPrev;
        
        
        }
        return dummy.next;
    }
}