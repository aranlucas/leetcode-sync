/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodesInA = new HashSet<ListNode>();

        while (headA != null) {
            nodesInA.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodesInA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}