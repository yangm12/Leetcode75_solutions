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
        
    }
}