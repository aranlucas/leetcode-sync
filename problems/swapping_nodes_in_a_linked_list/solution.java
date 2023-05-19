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
    public ListNode swapNodes(ListNode head, int k) {
        int listLength = 0;
        ListNode first = null;
        ListNode curr = head;
        // find the length of list and set the front node
        while (curr != null) {
            listLength++;
            if (listLength == k) {
                first = curr;
            }
            curr = curr.next;
        }
        // set the end node at (listLength - k)th node
        ListNode last = head;
        for (int i = 1; i <= listLength - k; i++) {
            last = last.next;
        }
        // swap front node and end node values
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
        return head;
    }
}
