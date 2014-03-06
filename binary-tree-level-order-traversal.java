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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) return result;
        
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        int count = 1;
        
        queue.add(root);
        while (count > 0) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int tmp = count;
            count = 0;
            while (tmp-- > 0) {
                TreeNode node = queue.poll();
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
            result.add(level);
        }
        
        return result;
    }
}
