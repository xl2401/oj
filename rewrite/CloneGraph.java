public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return helper(node, nodeMap);
    }

    private UndirectedGraphNode helper(UndirectedGraphNode node, HashMap<UndirectedGraphNode,UndirectedGraphNode> nodeMap) {
        if (node == null) return null;
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        nodeMap.put(node, root);
        List<UndirectedGraphNode> neis = node.neighbors;
        List<UndirectedGraphNode> newNeis = new ArrayList<UndirectedGraphNode>();
        for (UndirectedGraphNode nei: neis) {
            if (nodeMap.containsKey(nei)) {
                newNeis.add(nodeMap.get(nei));
            } else {
                UndirectedGraphNode neiRoot = helper(nei, nodeMap);
                newNeis.add(neiRoot);
            }
        }
        root.neighbors = newNeis;
        return root;
    }
}