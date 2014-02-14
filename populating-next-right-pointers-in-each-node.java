/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*
     * Utilize the fully constructed current level to construct the next level.
     *    1 -> NULL
     *   /  \
     *  2 -> 3 -> NULL
     * / \  / \
     *4  5  6  7
     */
    public void connect(TreeLinkNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        TreeLinkNode level = root;
        
        while (level != null && level.left != null) {
            TreeLinkNode parent = level, previousSibling = null;
            
            while (parent != null) {
                if (previousSibling != null) {
                    previousSibling.next = parent.left;
                }
                parent.left.next = parent.right;
                previousSibling = parent.right;
                parent = parent.next;
            }
            
            level = level.left;
        }
    }
}
