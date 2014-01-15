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
    private int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        findMaxToRoot(root);
        return max;
    }
    
    private int findMaxToRoot(TreeNode root) {
        if (root == null) return 0;
        
        int left = findMaxToRoot(root.left);
        int right = findMaxToRoot(root.right);
        
        if (left + right + root.val > max) max = left + right + root.val;
        
        return left > right ? (left + root.val > 0 ? left + root.val : 0) : (right + root.val > 0 ? right + root.val : 0);
    }
}
