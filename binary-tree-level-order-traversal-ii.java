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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        int count; // Count of nodes for current level.
        
        if (root == null) return result;
        
        queue.add(root);
        count = 1;
        while (queue.size() != 0) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int tmp = count;
            count = 0;
            while (tmp-- > 0) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    count++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    count++;
                }
            }
            result.add(0, level);
        }
        
        return result;
    }
}
