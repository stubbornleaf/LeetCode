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
    public boolean isSymmetric(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null) return true;
        return checkSymmetric(root.left, root.right);
    }
    
    private boolean checkSymmetric(TreeNode leftTree, TreeNode rightTree) {
        if ((leftTree == null && rightTree != null) ||(leftTree != null && rightTree == null)) return false;
        if (leftTree == null && leftTree == null) return true;
        if (leftTree.val != rightTree.val) return false;
        return checkSymmetric(leftTree.left, rightTree.right) && checkSymmetric(leftTree.right, rightTree.left);
    }
}
