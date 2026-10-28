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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) n++;

        int size = n / k;       // base size of each part
        int extra = n % k;      // first 'extra' parts get one more node

        ListNode[] res = new ListNode[k];
        ListNode cur = head;

        for (int i = 0; i < k && cur != null; i++) {
            res[i] = cur;
            int partSize = size + (i < extra ? 1 : 0);

            // move to the last node of this part
            for (int j = 1; j < partSize; j++) {
                cur = cur.next;
            }

            // cut the list and move on to the next part
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }
}