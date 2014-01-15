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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root, peekNode = null, lastVisitedNode = null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int tmpSum = 0;
        
        while (node != null || stack.peek() != null) {
            if (node != null) {
                stack.push(node);
                tmpSum += node.val;
                node = node.left;
            } else {
                peekNode = stack.peek();
                if (peekNode.right != null && peekNode.right != lastVisitedNode) {
                    node = peekNode.right;
                } else {
                    if (peekNode.left == null && peekNode.right == null && tmpSum == sum) {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        for (int index = stack.size() - 1; index >= 0; index--) {
                            tmp.add(stack.get(index).val);
                        }
                        result.add(tmp);
                    }
                    
                    lastVisitedNode = peekNode;
                    tmpSum -= peekNode.val;
                    stack.pop();
                }
            }
        }
        
        return result;
    }
}
