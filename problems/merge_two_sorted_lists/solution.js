/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function (l1, l2) {
  let list = new ListNode();
  let head = list;

  while (l1 && l2) {
    // Select smallest value from either link then increment

    if (l1.val < l2.val) {
      list.next = l1;
      l1 = l1.next;
    } else {
      list.next = l2;
      l2 = l2.next;
    }

    list = list.next;
  }

  list.next = l1 || l2;

  return head.next;
};