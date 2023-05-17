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
    public int pairSum(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            stack.addLast(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        int max = 0;
        while (mid != null) {
            int sum = mid.val + stack.removeLast().val;
            max = Math.max(sum, max);
            mid = mid.next;
        }

        return max;
    }
}