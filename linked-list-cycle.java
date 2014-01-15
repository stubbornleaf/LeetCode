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
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) return false;
        
        ListNode fastNode = head, slowNode = head;
        
        while (true) {
            slowNode = slowNode.next;
            if (slowNode == null) return false;
            
            fastNode = fastNode.next;
            if (fastNode == null) return false;
            fastNode = fastNode.next;
            if (fastNode == null) return false;
            
            if (slowNode == fastNode) return true;
        }
    }
}
