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
    public void reorderList(ListNode head) {
        
        // Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow is now in the middle.
        // Reverse the second half of List

        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Merge the two lists (head && prev)
        ListNode l1 = head;
        ListNode l2 = prev;
        while (l2.next != null) {
            ListNode tmp1 = l1.next;
            l1.next = l2;
            l1 = tmp1;
            
            ListNode tmp2 = l2.next;
            l2.next = l1;
            l2 = tmp2;
        }
    }
}