/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeLinkNode node;
        int count = 1;
        
        while (count > 0) {
            int tmp = count;
            count = 0;
            
            while (tmp-- > 1) {
                node = queue.poll();
                node.next = queue.peek();
                
                if (node.left != null) {
                    queue.offer(node.left);
                    count++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    count++;
                }
            }
            
            node= queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                count++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                count++;
            }
        }
    }
}
