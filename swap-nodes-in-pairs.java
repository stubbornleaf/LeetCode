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
    /*
     * newHead------>2------>1->4->3
     *      ^        ^      ^
     *      |        |      |
     * previousNode node nextNode
     */
    public ListNode swapPairs(ListNode head) {
        ListNode node, nextNode, previousNode, newHead = new ListNode(0);
        
        if (head == null) return null;
        if (head.next == null) return head;
        
        newHead.next = head;
        previousNode = newHead;
        while (previousNode.next != null && previousNode.next.next != null) {
            node = previousNode.next;
            nextNode = node.next;
            node.next = nextNode.next;
            nextNode.next = node;
            previousNode.next = nextNode;
            previousNode = node;
        }
        
        return newHead.next;
    }
}
