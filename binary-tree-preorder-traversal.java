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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        while (!stack.empty() || node != null) {
            if (node != null) {
                result.add(node.val);
                if (node.right != null) stack.push(node.right);
                node = node.left;
            } else {
                node = stack.pop();
            }
        }
        
        return result;
    }
}
