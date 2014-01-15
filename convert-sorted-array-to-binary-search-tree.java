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
    public TreeNode sortedArrayToBST(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return createBST(num, 0, num.length - 1);
    }
    
    private TreeNode createBST(int[] num, int left, int right) {
        if (left > right) return null;
        
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(num[middle]);
        
        root.left = createBST(num, left, middle - 1);
        root.right = createBST(num, middle + 1, right);
        
        return root;
    }
}
