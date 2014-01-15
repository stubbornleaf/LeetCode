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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd) return null;
        TreeNode node = new TreeNode(preorder[pStart]);
        int index = iStart;
        for (; index <= iEnd; index++) {
            if (preorder[pStart] == inorder[index]) break;
        }
        node.left = buildTree(preorder, pStart + 1, pStart + index - iStart, inorder, iStart, index - 1);
        node.right = buildTree(preorder, pStart + index - iStart + 1, pEnd, inorder, index + 1, iEnd);
        return node;
    }
}
