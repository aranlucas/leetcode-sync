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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (ListNode head : lists) {
            while (head != null) {
                q.add(head.val);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!q.isEmpty()) {
            curr.next = new ListNode(q.poll());
            curr = curr.next;
        }

        return dummy.next;
    }
}
