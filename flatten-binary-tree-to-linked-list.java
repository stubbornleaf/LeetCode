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
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        ArrayList<TreeNode> flat = new ArrayList<TreeNode>();
        
        while (!stack.empty() || node != null) {
            if (node != null) {
                flat.add(node);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        
        for (int i = 0; i < flat.size() - 1; i++) {
            flat.get(i).right = flat.get(i + 1);
            flat.get(i).left = null;
        }
    }
}
