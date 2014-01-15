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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head, previous = null;
        
        for (int i = 0; i < n; i++) p = p.next;
        
        while (p != null) {
            p = p.next;
            previous = q;
            q = q.next;
        }
        
        if (q == head) return q.next;
        else {
            previous.next = q.next;
            return head;
        }
    }
}
