public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        HashMap<String, Set<String>> graph = buildGraph(start, end, dict);
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> tmp = new ArrayList<String>();
        buildList(res, tmp, start, end, graph);
        return res;
    }

    // build result list according to graph
    // DFS
    private void buildList(List<List<String>> res, List<String> tmp, String cur, String end, HashMap<String, Set<String>> graph) {
        tmp.add(cur);
        if (cur.equals(end)) {
            res.add(tmp);
            return;
        }
        Set<String> children = graph.get(cur);
        if (children != null) {
            for (String child : children) {
                List<String> tmpList = new ArrayList<String>(tmp);
                buildList(res, tmpList, child, end, graph);
            }
        }
    }

    // build the graph structure in BFS fashion,
    // but a little bit different, here we do not use hash to record the visited nodes
    // instead we check if the current node is in last layer and last last layer
    // if not, we add this node
    private HashMap<String, Set<String>> buildGraph(String start, String end, Set<String> dict) {
        HashMap<String, Set<String>> res = new HashMap<String, Set<String>>();
        // last last layer
        HashSet<String> prevLayer = null;
        // last layer, visited but children not discovered yet
        HashSet<String> curLayer = new HashSet<String>();
        curLayer.add(start);
        boolean reachEnd = false;
        while (!reachEnd) {
            HashSet<String> newLayer = new HashSet<String>();
            for (String cur: curLayer) {
                HashSet<String> children = new HashSet<String>();
                for (int i = 0; i < cur.length(); i++) {
                    char[] strArray = cur.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == cur.charAt(i)) continue;
                        strArray[i] = c;
                        String newStr = new String(strArray);
                        if (newStr.equals(end)) {
                            reachEnd = true;
                        } else if (!dict.contains(newStr) || curLayer.contains(newStr) || (prevLayer != null && prevLayer.contains(newStr))) {
                            continue;
                        }
                        children.add(newStr);
                        newLayer.add(newStr);
                    }
                }
                res.put(cur, children);
            }
            if (newLayer.isEmpty()) break;
            prevLayer = curLayer;
            curLayer = newLayer;
        }
        return res;
    }
}
