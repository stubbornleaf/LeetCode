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
    public boolean isBalanced(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null) return true;
        
        return isBalancedHeight(root) != -1;
    }
    
    private int isBalancedHeight(TreeNode root) {
        if (root == null) return 0;
        
        int lHeight, rHeight;
        
        lHeight = isBalancedHeight(root.left);
        if (lHeight == -1) return -1;
        rHeight = isBalancedHeight(root.right);
        if (rHeight == -1) return -1;
        
        if (lHeight > rHeight + 1 || lHeight + 1 < rHeight) return -1;
        return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
    }
}
