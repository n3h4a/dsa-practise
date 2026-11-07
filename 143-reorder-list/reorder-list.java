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
        // 1. find the middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) { slow = slow.next; fast = fast.next.next; }
        // 2. reverse the second half
        ListNode prev = null, cur = slow.next;
        slow.next = null;
        while (cur != null) { ListNode next = cur.next; cur.next = prev; prev = cur; cur = next; }
        // 3. interleave the two halves
        ListNode a = head, b = prev;
        while (b != null) {
            ListNode an = a.next, bn = b.next;
            a.next = b;
            b.next = an;
            a = an;
            b = bn;
        }
    }
}