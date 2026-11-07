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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head), prev = dummy;
        while (prev.next != null) {
            ListNode cur = prev.next;
            if (cur.next != null && cur.next.val == cur.val) {
                int v = cur.val;
                while (cur != null && cur.val == v) cur = cur.next;  // drop the whole run
                prev.next = cur;
            } else {
                prev = cur;
            }
        }
        return dummy.next;
    }
}