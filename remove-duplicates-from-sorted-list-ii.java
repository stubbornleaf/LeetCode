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
        if (head == null) return head;
        
        ListNode headNode = new ListNode(head.val - 1), previous = headNode, node = head, beforePrevious = null;
        headNode.next = head;
        
        while (node != null) {
            if (node.val == previous.val) {
                while (node != null && node.val == previous.val) {
                    node = node.next;
                }
                
                if (node == null) {
                    beforePrevious.next = null;
                } else {
                    beforePrevious.next = node;
                    previous = node;
                    node = node.next;
                }
            } else {
                beforePrevious = previous;
                previous = node;
                node = node.next;
            }
        }
        
        return headNode.next;
    }
}
