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
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) return head;
        
        ListNode preNode = head, currentNode = head.next;
        int currentVal = head.val;
        
        while (currentNode != null) {
            if (currentNode.val == currentVal) {
                preNode.next = currentNode.next;
                currentNode = currentNode.next;
            } else {
                preNode = currentNode;
                currentVal = currentNode.val;
                currentNode = currentNode.next;
            }
        }
        
        return head;
    }
}
