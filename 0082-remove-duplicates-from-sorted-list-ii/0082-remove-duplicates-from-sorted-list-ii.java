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
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                int dup = curr.val;
                while (curr != null && curr.val == dup) {
                    curr = curr.next;
                }
                prev.next = curr;     // drop the whole run of duplicates
            } else {
                prev = curr;          // curr is unique, keep it
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}