// https://neetcode.io/problems/add-two-numbers/

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

// O(m + n);
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode curr = node;

        int over = 0;
        while(l1 != null || l2 != null || over != 0) {
            int valueL1 = (l1 != null)? l1.val : 0;
            int valueL2 = (l2 != null)? l2.val : 0;

            int value = valueL1 + valueL2 + over;

            over = value / 10;
            value = value % 10;
            curr.next = new ListNode(value);

            l1 = (l1 != null)? l1.next : null;
            l2 = (l2 != null)? l2.next : null;
            curr = curr.next;
        }

        return node.next;
    }
}
