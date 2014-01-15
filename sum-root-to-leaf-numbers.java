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
    public int sumNumbers(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root, peekNode, lastVisitedNode = null;
        int result = 0;
        
        while (node != null || stack.peek() != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                peekNode = stack.peek();
                if (peekNode.right != null && peekNode.right != lastVisitedNode) {
                    node = peekNode.right;
                } else {
                    if (peekNode.left == null && peekNode.right == null) {
                        int tmp = 0;
                        for (int index = stack.size() - 1; index >= 0; index--) {
                            tmp = tmp * 10 + stack.get(index).val;
                        }
                        result += tmp;
                    }
                    
                    stack.pop();
                    lastVisitedNode = peekNode;
                }
            }
        }
        
        return result;
    }
}
