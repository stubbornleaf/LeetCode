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
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(0), node = head, index, tmp;
        
        while (node != null) {
            index = newHead;
            while (index.next != null && index.next.val < node.val) index = index.next;
            tmp = node.next;
            node.next = index.next;
            index.next = node;
            node = tmp;
        }
        
        return newHead.next;
    }
}
