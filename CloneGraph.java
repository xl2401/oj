import java.util.ArrayList;
import java.util.HashMap;

/*
 * Title: Clone Graph
 * Description:
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * Solution:
 * Recur copy, maintain a visited hashmap
 */
public class CloneGraph {
    private HashMap<Integer, UndirectedGraphNode> hist = null;

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        hist = new HashMap<Integer, UndirectedGraphNode>();
        return cloneHelper(node);
    }

    public UndirectedGraphNode cloneHelper(UndirectedGraphNode node){
        if (node == null)
            return null;
        UndirectedGraphNode cur = new UndirectedGraphNode(node.label);
        // add to map before add neighbor to prevent self loop error
        hist.put(cur.label, cur);
        ArrayList<UndirectedGraphNode> neis = new ArrayList<UndirectedGraphNode>();
        for (UndirectedGraphNode nei: node.neighbors){
            if (hist.containsKey(nei.label)){
                neis.add(hist.get(nei.label));
            }
            else{
                neis.add(cloneHelper(nei));
            }
        }
        cur.neighbors = neis;
        return cur;
    }

    public static void main(String[] args){
        UndirectedGraphNode a = new UndirectedGraphNode(0);
        ArrayList<UndirectedGraphNode> neis = new ArrayList<UndirectedGraphNode>();
        neis.add(a);
        neis.add(a);
        a.neighbors = neis;
        CloneGraph cg = new CloneGraph();
        cg.cloneGraph(a);
    }
}
