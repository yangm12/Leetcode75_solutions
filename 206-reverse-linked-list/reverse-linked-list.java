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

        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while(temp.next!=null){
            stack.push(temp.val);
            temp = temp.next;
        }
        head = temp;
        while(!stack.isEmpty()){
            temp.next = new ListNode(stack.pop());
            temp = temp.next;
        }
        return head;
    }
}