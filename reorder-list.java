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
    public void reorderList(ListNode head) {
        if (head == null) return;
        
        ListNode node1 = head, node2 = head, previous = null, tmp = null;
        
        // Find the start node of second half list.
        while (node1.next != null && node1.next.next != null) {
            node1 = node1.next.next;
            node2 = node2.next;
        }
        tmp = node2;
        node2 = node2.next;
        tmp.next = null;
        
        // Revert the second half list.
        while (node2 != null) {
            tmp = node2;
            node2 = node2.next;
            tmp.next = previous;
            previous = tmp;
        }
        node2 = previous;
        
        node1 = head;
        while (node2 != null) {
            ListNode tmp1 = node1, tmp2 = node2;
            node1 = node1.next;
            node2 = node2.next;
            tmp1.next = tmp2;
            tmp2.next = node1;
        }
    }
}
