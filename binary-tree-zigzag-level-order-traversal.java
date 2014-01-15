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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) return result;
        
        LinkedList<TreeNode> deque1 = new LinkedList<TreeNode>(), deque2 = new LinkedList<TreeNode>();;
        boolean lToR = true;
        
        deque1.add(root);
        while ((lToR && deque1.size() != 0) || (!lToR && deque2.size() != 0)) {
            if (lToR) {
                ArrayList<Integer> newRow = new ArrayList<Integer>();
                while (deque1.size() != 0) {
                    TreeNode tmp = deque1.pollFirst();
                    newRow.add(tmp.val);
                    if (tmp.left != null) deque2.addLast(tmp.left);
                    if (tmp.right != null) deque2.addLast(tmp.right);
                }
                result.add(newRow);
            } else {
                ArrayList<Integer> newRow = new ArrayList<Integer>();
                while (deque2.size() != 0) {
                    TreeNode tmp = deque2.pollLast();
                    newRow.add(tmp.val);
                    if (tmp.right != null) deque1.addFirst(tmp.right);
                    if (tmp.left != null) deque1.addFirst(tmp.left);
                }
                result.add(newRow);
            }
            
            lToR = !lToR;
        }
        
        return result;
    }
}
