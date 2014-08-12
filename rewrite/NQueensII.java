class Counter {
    public int cnt;
    public Counter(int cnt) {
        this.cnt = cnt;
    }
}

public class Solution {
    public int totalNQueens(int n) {
        Counter cnter = new Counter(0);
        int[] columnForRow = new int[n];
        helper(cnter, 0, n, columnForRow);
        return cnter.cnt;
    }
    
    private void helper(Counter cnter, int row, int n, int[] columnForRow) {
        // end
        if (row == n)
        	cnter.cnt++;
        else {
            // iterate every col
            for (int j = 0; j < n; j++) {
                columnForRow[row] = j;
                if (checkValid(row, columnForRow)){
                	helper(cnter, row+1, n, columnForRow);
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
