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
    public boolean isPalindrome(ListNode head) {
        // find the middle, reverse the second half, compare
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        ListNode prev = null;
        while (slow != null) { ListNode next = slow.next; slow.next = prev; prev = slow; slow = next; }
        for (ListNode a = head, b = prev; b != null; a = a.next, b = b.next)
            if (a.val != b.val) return false;
        return true;
    }
}