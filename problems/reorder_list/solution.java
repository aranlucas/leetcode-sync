/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {
  public void reorderList(ListNode head) {
    if (head == null) return;

    ListNode slow = head;
    ListNode fast = head;

    // Find middle node
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // reverse the second part of the list
    // convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
    // reverse the second half in-place
    ListNode prev = null;
    ListNode curr = slow;
    ListNode tmp = null;

    while (curr != null) {
      tmp = curr.next;

      curr.next = prev;
      prev = curr;
      curr = tmp;
    }

    // merge two sorted linked lists [Problem 21]
    // merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
    ListNode first = head;
    ListNode second = prev;

    while (second.next != null) {
      tmp = first.next;
      first.next = second;
      first = tmp;

      tmp = second.next;
      second.next = first;
      second = tmp;
    }
  }
}
