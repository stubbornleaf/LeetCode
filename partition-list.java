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
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(-1), node = head, last = newHead, previous = newHead;
        newHead.next = head;
        
        while (node != null) {
            if (node.val < x) {
                if (last.next != node) {
                    ListNode tmp = node;
                    node = node.next;
                    previous.next = node;
                    
                    tmp.next = last.next;
                    last.next = tmp;
                    last = tmp;
                } else {
                    previous = node;
                    node = node.next;
                    last = last.next;
                }
            } else {
                previous = node;
                node = node.next;
            }
        }
        
        return newHead.next;
    }
}
