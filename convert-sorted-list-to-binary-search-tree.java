/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        
        ListNode left, right, faster = head, slower = head, lastLeft = null;
        
        while (faster.next != null && faster.next.next != null) {
            lastLeft = slower;
            slower = slower.next;
            faster = faster.next.next;
        }
        
        if (slower == head) {
            left = null;
        } else {
            left = head;
            lastLeft.next = null;
        }
        right = slower.next;
        
        TreeNode root = new TreeNode(slower.val);
        root.left = sortedListToBST(left);
        root.right = sortedListToBST(right);
        
        return root;
    }
}
