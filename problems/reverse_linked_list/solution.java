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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        ListNode cur = head;

        // 1->2->4->5->null
        while (cur != null) {
            // Save next node since next link disappears
            // p->c->
            // 1->2->4->5->null
            ListNode nextTemp = cur.next;

            // Disconnect next and assign to prev
            // p<-c  t
            // 1->2->4->5->null
            cur.next = prev;
            // Set previous to current
            prev = cur;
            // Move list forward
            cur = nextTemp;
        }

        return prev;
    }
}
