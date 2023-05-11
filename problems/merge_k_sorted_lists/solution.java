/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> q = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);

        for (ListNode l : lists) {
            if (l != null) {
                q.add(l);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!q.isEmpty()) {
            curr.next = q.poll();
            curr = curr.next;
            ListNode tmp = curr.next;
            if (tmp != null) {
                q.add(tmp);
            }
        }

        return dummy.next;
    }
}
