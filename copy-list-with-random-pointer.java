/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode node = head, previousCopy = new RandomListNode(-1), copyHead = previousCopy, copy;
        
        while (node != null) {
            copy = new RandomListNode(node.label);
            copy.next = null;
            copy.random = null;
            previousCopy.next = copy;
            previousCopy = copy;
            map.put(node, copy);
            node = node.next;
        }
        
        node = head;
        copy = copyHead.next;
        while (node != null) {
            if (node.random == null) {
                copy.random = null;
            } else {
                copy.random = map.get(node.random);
            }
            node = node.next;
            copy = copy.next;
        }
        
        return copyHead.next;
    }
}
