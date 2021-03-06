/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        
        ListNode result = new ListNode(-1), node = result;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        
        // Initialize heap.
        for (int index = 0; index < lists.size(); index++) {
            if (lists.get(index) != null) heap.offer(lists.get(index));
        }
        
        while (heap.size() != 0) {
            ListNode tmp = heap.poll();
            // Put the next node into heap if it's not null.
            if (tmp.next != null) {
                heap.offer(tmp.next);
            }
            node.next = tmp;
            node = tmp;
        }
        
        return result.next;
    }   
}
