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
        
        LinkedList<TreeNode> deque = new LinkedList<TreeNode>();
        boolean lToR = true;
        int count = 1;
        
        deque.add(root);
        while (count > 0) {
            int tmpCount = count;
            count = 0;
            if (lToR) {
                ArrayList<Integer> newRow = new ArrayList<Integer>();
                while (tmpCount-- > 0) {
                    TreeNode tmp = deque.pollFirst();
                    newRow.add(tmp.val);
                    if (tmp.left != null) {
                        deque.addLast(tmp.left);
                        count++;
                    }
                    if (tmp.right != null) {
                        deque.addLast(tmp.right);
                        count++;
                    }
                }
                result.add(newRow);
            } else {
                ArrayList<Integer> newRow = new ArrayList<Integer>();
                while (tmpCount-- > 0) {
                    TreeNode tmp = deque.pollLast();
                    newRow.add(tmp.val);
                    if (tmp.right != null) {
                        deque.addFirst(tmp.right);
                        count++;
                    }
                    if (tmp.left != null) {
                        deque.addFirst(tmp.left);
                        count++;
                    }
                }
                result.add(newRow);
            }
            
            lToR = !lToR;
        }
        
        return result;
    }
}
