/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        ListNode left, right, newHead = new ListNode(-1), tmp = newHead;
        
        if (head == null || head.next == null) {
            return head;
        }
        
        left = head;
        right = head.next;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        
        right = left.next;
        left.next = null;
        left = head;
        
        left = sortList(left);
        right = sortList(right);
        
        while (left != null && right != null) {
            if (left.val > right.val) {
                tmp.next = right;
                right = right.next;
            } else {
                tmp.next = left;
                left = left.next;
            }
            tmp = tmp.next;
        }
        
        if (left != null) {
            tmp.next = left;
        }
        if (right != null) {
            tmp.next = right;
        }
        
        return newHead.next;
    }
}
