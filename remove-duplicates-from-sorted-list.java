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
        
        ListNode previousNode = head, currentNode = head.next;
        int previousVal = head.val;
        
        while (currentNode != null) {
            if (currentNode.val == previousVal) {
                currentNode = currentNode.next;
                previousNode.next = currentNode;
            } else {
                previousNode = currentNode;
                previousVal = currentNode.val;
                currentNode = currentNode.next;
            }
        }
        
        return head;
    }
}
