import java.util.LinkedList;

public class Solution {
    public void connect(TreeLinkNode root) {  
    	// extreme null check
    	if (root == null) return;
    	LinkedList<TreeLinkNode> lastLayer = new LinkedList<TreeLinkNode>();
    	lastLayer.add(root);
    	while (!lastLayer.isEmpty()) {
    		LinkedList<TreeLinkNode> curLayer = new LinkedList<TreeLinkNode>();
    		for (TreeLinkNode node: lastLayer) {
    			if (node.left != null)
    				curLayer.add(node.left);
    			if (node.right != null)
    				curLayer.add(node.right);
    		}
    		connectList(curLayer);
    		lastLayer = curLayer;
    	}
    }
    
    private void connectList(LinkedList<TreeLinkNode> list) {
    	// dummy node
    	TreeLinkNode prev = new TreeLinkNode(0);
    	for (TreeLinkNode node: list) {
    		prev.next = node;
    		prev = node;
    	}
    }
}
