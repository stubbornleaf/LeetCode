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
    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root, peekNode, lastVisitedNode = null;
        int minDepth = Integer.MAX_VALUE, tmp = 0;
        
        if (node == null) return 0;
        while (node != null || stack.peek() != null) {
            if (node != null) {
                stack.push(node);
                tmp++;
                node = node.left;
            } else {
                peekNode = stack.peek();
                if (peekNode.right != null && lastVisitedNode != peekNode.right) {
                    node = peekNode.right;
                } else {
                    if (peekNode.left == null && peekNode.right == null && tmp < minDepth) minDepth = tmp;
                    
                    stack.pop();
                    tmp--;
                    lastVisitedNode = peekNode;
                }
            }
        }
        
        return minDepth;
    }
}
