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
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head, newNode, newList = new RandomListNode(Integer.MIN_VALUE);
        
        while (node != null) {
            newNode = new RandomListNode(node.label);
            map.put(node, newNode);
            node = node.next;
        }
        
        node = head;
        newNode = newList;
        while (node != null) {
            newNode.next = map.get(node);
            newNode = newNode.next;
            newNode.random = map.get(node.random);
            node = node.next;
        }
        
        return newList.next;
    }
}
