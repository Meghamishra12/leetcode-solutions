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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1. Find the length and the tail
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // 2. Rotating by a multiple of len changes nothing
        k %= len;
        if (k == 0) return head;

        // 3. Close the list into a ring
        tail.next = head;

        // 4. New tail is (len - k - 1) steps from the old head
        ListNode newTail = head;
        for (int i = 0; i < len - k - 1; i++) {
            newTail = newTail.next;
        }

        // 5. Break the ring after the new tail
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}