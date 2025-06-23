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
    public int pairSum(ListNode head) {
        if(head.next==null) return head.val+head.next.val;
        
        /* Beats 29.86% runtime, 32.08% memory
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp.next!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        list.add(temp.val);

        // Loop each half
        int left = 0, right = list.size()-1;
        int res = 0;
        while(left<list.size()/2 && right>=list.size()/2){
            res = Math.max(list.get(left)+list.get(right), res);
            left++;
            right--;
        }
        return res;
        */

        // 1. Find the middle index using slow-fast pointers
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half of the list
        ListNode prev = null;
        while(slow!=null){
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        // 3. Find twin sums from the start and the reversed second half
        int res = 0;
        ListNode start = head;
        ListNode end = prev;    // The last node of the reversed second half
        while(end!=null){
            res = Math.max(res, start.val+end.val);
            start = start.next;
            end = end.next;
        }
        return res;
    }
}