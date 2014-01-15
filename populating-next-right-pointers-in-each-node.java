/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null || root.left == null) return;
        
        TreeLinkNode node = root, parent, previousSibling;
        
        while (node.left != null) {
            parent = node;
            node = node.left;
            previousSibling = null;
            while (parent != null) {
                if (previousSibling != null) {
                    previousSibling.next = parent.left;
                }
                parent.left.next = parent.right;
                previousSibling = parent.right;
                parent = parent.next;
            }
        }
    }
}
