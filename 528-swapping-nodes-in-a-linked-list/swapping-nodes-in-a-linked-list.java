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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        for (int i = 1; i < k; i++) first = first.next;  // k-th from start
        ListNode second = head, fast = first;
        while (fast.next != null) { fast = fast.next; second = second.next; }  // k-th from end
        int t = first.val; first.val = second.val; second.val = t;
        return head;
    }
}