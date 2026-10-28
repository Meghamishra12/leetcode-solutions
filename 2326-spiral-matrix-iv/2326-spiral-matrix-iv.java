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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        for (int[] row : mat) Arrays.fill(row, -1);

        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (head != null && top <= bottom && left <= right) {
            // left -> right along the top row
            for (int j = left; j <= right && head != null; j++) {
                mat[top][j] = head.val;
                head = head.next;
            }
            top++;

            // top -> bottom along the right column
            for (int i = top; i <= bottom && head != null; i++) {
                mat[i][right] = head.val;
                head = head.next;
            }
            right--;

            // right -> left along the bottom row
            if (top <= bottom) {
                for (int j = right; j >= left && head != null; j--) {
                    mat[bottom][j] = head.val;
                    head = head.next;
                }
                bottom--;
            }

            // bottom -> top along the left column
            if (left <= right) {
                for (int i = bottom; i >= top && head != null; i--) {
                    mat[i][left] = head.val;
                    head = head.next;
                }
                left++;
            }
        }

        return mat;
    }
}