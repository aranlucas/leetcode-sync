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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            // Nodes to be swapped
            ListNode node1 = cur;
            ListNode node2 = cur.next;

            // Swap values
            prevNode.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            // Reinitializing the head and prevNode for next swap
            prevNode = node1;
            // jump to next
            cur = node1.next; // ...[...]-->[node2]-->[node1/prev]-->[next]...
        }

        // Return new head
        return dummy.next;
    }
}
