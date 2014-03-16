import java.util.LinkedList;
import java.util.Iterator;

class InorderIterator implements Iterator<TreeNode>{
    private TreeNode cur = null;
    private LinkedList<TreeNode> stack = null;
    
    public InorderIterator(TreeNode root){
        this.cur = root;
        stack = new LinkedList<TreeNode>();
    }
    
    public boolean hasNext(){
        if (cur == null && stack.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    
    public TreeNode next(){
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        // now cur is null, has reached left most leaf
        TreeNode last = stack.pop();
        cur = last.right;
        return last;
    }

    public void remove(){
        // not supported
    }
}
