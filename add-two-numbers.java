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
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1, node2 = l2, newList = new ListNode(-1), node = newList, tmp;
        int carry = 0;
        
        while (node1 != null && node2 != null) {
            int val = node1.val + node2.val + carry;
            if (val >= 10) {
                tmp = new ListNode(val % 10);
                carry = 1;
            } else {
                tmp = new ListNode(val);
                carry = 0;
            }
            node.next = tmp;
            node = tmp;
            node1 = node1.next;
            node2 = node2.next;
        }
        
        if (node1 != null || node2 != null) {
            ListNode previous;
            node.next = node1 != null ? node1 : node2;
            previous = node;
            node = node.next;
            while (node != null && carry == 1) {
                int val = node.val + 1;
                node.val = val % 10;
                carry = val / 10;
                previous = node;
                node = node.next;
            }
            if (carry == 1) {
                tmp = new ListNode(1);
                previous.next = tmp;
            }
        } else if (carry == 1) {
            tmp = new ListNode(1);
            node.next = tmp;
        }
        
        return newList.next;
    }
}
