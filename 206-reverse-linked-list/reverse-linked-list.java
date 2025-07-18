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
    public ListNode reverseList(ListNode head) {
        // Base case
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode ln = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = ln;
            ln = head;
            head = temp;
        }
        return ln;
    }
}