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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        ArrayList<Integer> traverse = new ArrayList<Integer>();
        TreeNode node = root;
        
        while (node != null || stack.size() != 0) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode peekNode = stack.pop();
                traverse.add(peekNode.val);
                node = peekNode.right;
            }
        }
        
        if (traverse.size() == 1) return true;
        for (int index = 1; index < traverse.size(); index++) {
            if (traverse.get(index) <= traverse.get(index - 1)) return false;
        }
        return true;
    }
}
