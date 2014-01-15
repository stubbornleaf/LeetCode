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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root, lastVisitedNode = null, peekNode;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        while (stack.size() != 0 || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                peekNode = stack.peek();
                if (peekNode.right != null && peekNode.right != lastVisitedNode) {
                    node = peekNode.right;
                } else {
                    stack.pop();
                    result.add(peekNode.val);
                    lastVisitedNode = peekNode;
                }
            }
        }
        
        return result;
    }
}
