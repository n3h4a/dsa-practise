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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstPos = -1, lastPos = -1, minDist = Integer.MAX_VALUE, pos = 1;
        for (ListNode prev = head, cur = head.next; cur.next != null; prev = cur, cur = cur.next, pos++) {
            boolean isMax = cur.val > prev.val && cur.val > cur.next.val;
            boolean isMin = cur.val < prev.val && cur.val < cur.next.val;
            if (!isMax && !isMin) continue;
            if (firstPos == -1) firstPos = pos;
            else minDist = Math.min(minDist, pos - lastPos);
            lastPos = pos;
        }
        if (minDist == Integer.MAX_VALUE) return new int[]{-1, -1};
        return new int[]{minDist, lastPos - firstPos};
    }
}