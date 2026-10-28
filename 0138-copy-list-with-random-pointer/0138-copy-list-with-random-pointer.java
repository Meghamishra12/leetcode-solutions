/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    // Step 1: random ke bina deep copy (sirf next)
    public Node deepCopy(Node head) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node curr = head;
        while (curr != null) {
            temp.next = new Node(curr.val);
            temp = temp.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    // Step 2: dono lists ko alternate jodna: A -> A' -> B -> B' ...
    public void merge(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp2 != null) {
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;

            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }
    }

    // Step 3: random pointers set karna
    public void connectRandom(Node head1) {
        Node temp = head1;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next; // copy.random = original.random ki copy
            }
            temp = temp.next.next;
        }
    }

    // Step 4: lists ko alag karna
    public Node separate(Node head1) {
        Node head2 = head1.next;
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null) {
            temp1.next = temp2.next;
            temp1 = temp1.next;
            if (temp1 != null) {
                temp2.next = temp1.next;
                temp2 = temp2.next;
            }
        }
        return head2;
    }

    public Node copyRandomList(Node head1) {
        if (head1 == null) return null;
        Node head2 = deepCopy(head1);      // Step 1
        merge(head1, head2);               // Step 2
        connectRandom(head1);              // Step 3
        return separate(head1);            // Step 4
    }
}