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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue <Integer> q = new PriorityQueue <> () ;
        
        for(ListNode list: lists){
            while(list!=null)
                {
                    q.add(list.val);
                    list = list.next;
                }
           
        }
        
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        
        while(!q.isEmpty())
        {
            head.next = new ListNode(q.remove());
            head = head.next;
        }
        return dummy.next;
        
    }
}