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
        Stack<TreeNode> stack = new Stack<>();
        int result = 0, current = 0;
        TreeNode node = root, last = null, peek = null;
        
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                current = current * 10 + node.val;
                node = node.left;
            } else {
                peek = stack.peek();
                if (peek.right == null || last == peek.right) {
                    stack.pop();
                    if (peek.left == null && peek.right == null) {
                        result += current;
                    }
                    current /= 10;
                    last = peek;
                } else {
                    node = peek.right;
                }
            }
        }
        
        return result;
    }
}
