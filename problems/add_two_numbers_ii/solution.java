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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int totalSum = 0;
        int carry = 0;

        Stack<Integer> sum = new Stack<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                totalSum += stack1.pop();
            }

            if (!stack2.isEmpty()) {
                totalSum += stack2.pop();
            }
            sum.push(totalSum % 10);
            carry = totalSum / 10;
            totalSum = carry;
        }

        ListNode ans = new ListNode(1);
        ListNode cur = ans;
        while (!sum.isEmpty()) {
            ListNode yes = new ListNode(sum.pop());
            cur.next = yes;
            cur = cur.next;
        }
        return carry == 0 ? ans.next : ans;
    }
}
