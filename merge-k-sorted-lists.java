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
        
        for (int index = 0; index < lists.size(); index++) {
            if (lists.get(index) != null) heap.offer(lists.get(index));
        }
        
        while (heap.size() != 0) {
            ListNode tmp = heap.poll();
            for (int index = 0; index < lists.size(); index++) {
                ListNode list = lists.get(index);
                if (list == tmp) {
                    lists.remove(list);
                    if (list.next != null) {
                        heap.offer(list.next);
                        lists.add(list.next);
                    }
                    break;
                }
            }
            node.next = tmp;
            node = tmp;
        }
        
        return result.next;
    }
}
