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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        
        ListNode newHead = new ListNode(-1), previous = newHead, next, first, second = null, tmp, node;
        newHead.next = head;
        
        while (true) {
            node = previous.next;
            int count = 0;
            while (node != null && count < k) {
                count++;
                node = node.next;
            }
            
            if (count < k) {
                break;
            }
            
            first = previous.next;
            second = first.next;
            for (int index = 1; index < k; index++) {
                tmp = second.next;
                second.next = first;
                first = second;
                second = tmp;
            }
            previous.next.next = second;
            tmp = previous.next;
            previous.next = first;
            
            previous = tmp;
        }
        
        return newHead.next;
    }
}
