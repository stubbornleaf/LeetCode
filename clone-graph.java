/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        
        map.put(node, copy);
        stack.push(node);
        while (!stack.empty()) {
            UndirectedGraphNode tmp = stack.pop();
            for (UndirectedGraphNode neighbor : tmp.neighbors) {
                if (!map.containsKey(neighbor)) {
                    UndirectedGraphNode newCopy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newCopy);
                    stack.push(neighbor);
                }
            }
        }
        
        for (UndirectedGraphNode key : map.keySet()) {
            ArrayList<UndirectedGraphNode> newNeighbors = new ArrayList<UndirectedGraphNode>();
            UndirectedGraphNode tmp = map.get(key);
            for (UndirectedGraphNode neighbor : key.neighbors) {
                newNeighbors.add(map.get(neighbor));
            }
            tmp.neighbors = newNeighbors;
        }
        
        return copy;
    }
}
