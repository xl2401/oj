public class Solution {
    public List<String[]> solveNQueens(int n) {
        // use res as a parameter, easy to collect res from recursive calls
        List<String[]> res = new ArrayList<String[]>();
        int[] columnForRow = new int[n];
        helper(res, 0, n, columnForRow);
        return res;
    }
    
    private void helper(List<String[]> res, int row, int n, int[] columnForRow) {
        // end
        if (row == n)
        	res.add(generateRes(columnForRow));
        else {
            // iterate every col
            for (int j = 0; j < n; j++) {
                columnForRow[row] = j;
                if (checkValid(row, columnForRow)){
                	helper(res, row+1, n, columnForRow);
                }
            }
        }
    }
    
    private boolean checkValid(int row, int[] columnForRow) {
        // check every line
        for (int i = 0; i < row; i++) {
            // check same col
            if (columnForRow[i] == columnForRow[row]) return false;
            if (row-i == Math.abs(columnForRow[i]-columnForRow[row])) return false;
        }
        return true;
    }

    private String[] generateRes(int[] columnForRow) {
    	int N = columnForRow.length;
    	String[] res = new String[N];
        for (int i = 0; i < N; i++) {
            int qCol = columnForRow[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
            if (j == qCol)
            	sb.append('Q');
            else
            	sb.append('.');
            }
            res[i] = sb.toString();
        }
        return res;
    }
}
