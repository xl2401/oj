import java.util.ArrayList;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) return result;
        for (int i = 0; i < numRows; i++){
            ArrayList<Integer> currentRow = new ArrayList<Integer>();
            for (int j = 0; j <=i; j++){
                if (j == 0 || j == i) currentRow.add(1);
                else{
                    ArrayList<Integer> previousRow = result.get(i-1);
                    currentRow.add(previousRow.get(j-1) + previousRow.get(j));
                }
            }
            result.add(currentRow);
        }
        return result;
    }
}
