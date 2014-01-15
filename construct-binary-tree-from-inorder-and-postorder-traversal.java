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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd) return null;
        
        Integer rootVal = postorder[pEnd];
        TreeNode root = new TreeNode(rootVal);
        
        int index = iStart;
        for (; index < iEnd; index++) {
            if (inorder[index] == rootVal) break;
        }
        
        root.left = buildTree(inorder, iStart, index - 1, postorder, pStart, pStart + index - iStart - 1);
        root.right = buildTree(inorder, index + 1, iEnd, postorder, pStart + index - iStart, pEnd - 1);
        return root;
    }
}
