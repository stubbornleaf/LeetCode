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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode newHead =  new ListNode(-1), last = newHead, node = head.next;
        int prevVal = head.val;
        boolean hasDup = false;
        
        newHead.next = head;
        while (node != null) {
            if (node.val == prevVal) {
                hasDup = true;
            } else {
                if (hasDup) {
                    last.next = node;
                    hasDup = false;
                } else {
                    last = last.next;
                }
                prevVal = node.val;
            }
            node = node.next;
        }
        if (hasDup) {
            last.next = null;
        }
        
        return newHead.next;
    }
}
