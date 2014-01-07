import java.util.LinkedList;

public class PopNextRightPtr {
    public void connect(TreeLinkNode root) {
        LinkedList<TreeLinkNode> lastLayer = new LinkedList<TreeLinkNode>();
        TreeLinkNode dummy = new TreeLinkNode(0);
        dummy.left = root;
        lastLayer.add(dummy);
        while (!lastLayer.isEmpty()){
            LinkedList<TreeLinkNode> curLayer = new LinkedList<TreeLinkNode>();
            while (!lastLayer.isEmpty()){
                TreeLinkNode pa = lastLayer.pop();
                if (pa.left != null) curLayer.add(pa.left);
                if (pa.right!= null) curLayer.add(pa.right);
            }
            connectList(curLayer);
            lastLayer = curLayer;
        }
    }

    public void connectList(LinkedList<TreeLinkNode> list){
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode prev = dummy;
        for (TreeLinkNode node: list){
            prev.next = node;
            prev = node;
        }
    }

    public static void main(String[] args){
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode b = new TreeLinkNode(2);
        TreeLinkNode c = new TreeLinkNode(3);
        a.left = b;
        a.right = c;
        new PopNextRightPtr().connect(a);
    }
}
