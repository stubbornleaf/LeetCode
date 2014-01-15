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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode headNode = new ListNode(0), node, next, previous = null, nodeM = headNode;
        headNode.next = head;
        
        for (int index = 0; index < m; index++) {
            previous = nodeM;
            nodeM = nodeM.next;
        }
        
        node = nodeM;
        next = node.next;
        for (int index = m + 1; index <= n; index++) {
            ListNode tmp = next.next;
            next.next = node;
            node = next;
            next = tmp;
        }
        
        previous.next = node;
        nodeM.next = next;
        
        return headNode.next;
    }
}
