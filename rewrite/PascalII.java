public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(1);
            return res;
        }
        List<Integer> last = getRow(rowIndex-1);
        List<Integer> cur = new ArrayList<Integer>();
        for (int i = 0; i <= last.size(); i++) {
            if (i == 0 || i == last.size())
            	cur.add(1);
            else
            	cur.add(last.get(i)+last.get(i-1));
        }
    	return cur;
    }
}