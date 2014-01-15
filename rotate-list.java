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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return null;
        
        ListNode newHead = new ListNode(-1), node = newHead, nextN = head, nextN1 = newHead;
        int index = 0;
        newHead.next = head;
        
        while (index < n) {
            if (nextN.next == null) {
                nextN1 = newHead;
                nextN = head;
            } else {
                nextN1 = nextN;
                nextN = nextN.next;
            }
            index++;
        }
        if (nextN == null) return head;
        
        while (nextN != null) {
            nextN = nextN.next;
            nextN1 = nextN1.next;
            node = node.next;
        }
        
        nextN1.next = head;
        newHead.next = node.next;
        node.next = null;
        
        return newHead.next;
    }
}
