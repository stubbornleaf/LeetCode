/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    private ArrayList<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        
        if (start > end) {
            result.add(null);
            return result;
        }
        
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> leftTrees = generateTrees(start, i - 1);
            ArrayList<TreeNode> rightTrees = generateTrees(i + 1, end);
            
            for (int j = 0; j < leftTrees.size(); j++) {
                for (int k = 0; k < rightTrees.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTrees.get(j);
                    root.right = rightTrees.get(k);
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}
