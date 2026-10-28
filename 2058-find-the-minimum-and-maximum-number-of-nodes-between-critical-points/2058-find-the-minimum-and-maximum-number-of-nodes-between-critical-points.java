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
        int[] ans = {-1, -1};
        int idx = 1, firstIdx = -1, lastIdx = -1, minDist = Integer.MAX_VALUE;

        ListNode a = head;
        ListNode b = a.next;
        if (b == null || b.next == null) return ans; // fewer than 3 nodes
        ListNode c = b.next;

        while (c != null) {
            // b is at index idx
            if ((b.val > a.val && b.val > c.val) || (b.val < a.val && b.val < c.val)) {
                if (firstIdx == -1) firstIdx = idx;
                if (lastIdx != -1) {
                    minDist = Math.min(minDist, idx - lastIdx);
                }
                lastIdx = idx;
            }
            idx++;
            a = a.next;
            b = b.next;
            c = c.next;
        }

        if (firstIdx == lastIdx) return ans; // 0 or 1 critical points

        ans[0] = minDist;
        ans[1] = lastIdx - firstIdx;
        return ans;
    }
}