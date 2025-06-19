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
    public ListNode deleteMiddle(ListNode head) {
        // Base Case:
        if(head==null) return null;

        // Approach: slow point just before the middle node 
        // by the time fast reaches the end of the list.
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode slow = prev;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // When the loop ends, slow.next is the middle node
        // Hence, pointing slow.next to slow.next.next removes the middle node
        slow.next = slow.next.next;
        return prev.next;
    }
}