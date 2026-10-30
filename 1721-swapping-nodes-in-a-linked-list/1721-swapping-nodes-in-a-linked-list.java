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
        // Move `first` to the kth node from the start
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        ListNode kthFromStart = first;

        // Start `second` at head and advance both until `first` hits the last node.
        // `second` then sits at the kth node from the end.
        ListNode second = head;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // Swap the values
        int temp = kthFromStart.val;
        kthFromStart.val = second.val;
        second.val = temp;

        return head;
    }
}