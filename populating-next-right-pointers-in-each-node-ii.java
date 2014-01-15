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
        if (root == null) return;
        
        TreeLinkNode node = root;
        
        while (node != null) {
            TreeLinkNode newRow = null, tmp = null;
            
            while (node != null) {
                if (node.left != null) {
                    if (newRow == null) {
                        newRow = node.left;
                        tmp = newRow;
                    } else {
                        tmp.next = node.left;
                        tmp = node.left;
                    }
                }
                if (node.right != null) {
                    if (newRow == null) {
                        newRow = node.right;
                        tmp = newRow;
                    } else {
                        tmp.next = node.right;
                        tmp = node.right;
                    }
                }
                
                node = node.next;
            }
            
            node = newRow;
        }
    }
}
