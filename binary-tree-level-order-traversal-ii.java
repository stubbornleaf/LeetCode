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
        Deque<TreeNode> queue1 = new ArrayDeque<TreeNode>(), queue2 = new ArrayDeque<TreeNode>(), tmp1, tmp2;
        
        if (root == null) return result;
        
        queue1.add(root);
        while (queue1.size() != 0 || queue2.size() != 0) {
            if (queue1.size() != 0) {
                tmp1 = queue1;
                tmp2 = queue2;
            } else {
                tmp1 = queue2;
                tmp2 = queue1;
            }
            
            ArrayList<Integer> level = new ArrayList<Integer>();
            while (tmp1.peek() != null) {
                TreeNode node = tmp1.remove();
                level.add(node.val);
                if (node.left != null) {
                    tmp2.add(node.left);
                }
                if (node.right != null) {
                    tmp2.add(node.right);
                }
            }
            result.add(0, level);
        }
        
        return result;
    }
}
