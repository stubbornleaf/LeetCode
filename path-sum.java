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
    public boolean hasPathSum(TreeNode root, int sum) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root, lastPopedNode = null, peekNode = null;
        int tmp = 0;
        
        if (root == null) return false;
        
        while (node != null || stack.peek() != null) {
            if (node != null) {
                stack.push(node);
                tmp += node.val;
                node = node.left;
            } else {
                peekNode = stack.peek();
                if (peekNode.right != null && lastPopedNode != peekNode.right) {
                    node = peekNode.right;
                } else {
                    if (peekNode.left == null && peekNode.right == null && tmp == sum) return true;
                    
                    stack.pop();
                    tmp -= peekNode.val;
                    lastPopedNode = peekNode;
                }
            }
        }
        
        return false;
    }
}
