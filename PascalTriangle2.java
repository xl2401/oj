import java.util.ArrayList;

public class PascalTriangle2 {
    public ArrayList<Integer> buffer;
    
    public ArrayList<Integer> getRowRecur(int rowIndex){
        if (rowIndex == 0){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(1);
            return result;
        }
        if (rowIndex == 1){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(1);
            result.add(1);
            return result;
        }
        ArrayList<Integer> result = getRowRecur(rowIndex-1);
        // copy previous to buffer
        for (int i = 0; i < result.size(); i++){
            buffer.set(i, result.get(i));
        }
        for (int i = 1; i < rowIndex; i++){
            result.set(i, buffer.get(i) + buffer.get(i-1));
        }
        result.add(1);
        return result;
    }
    public ArrayList<Integer> getRow(int rowIndex) {
        buffer = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++){
            buffer.add(0);
        }
        return getRowRecur(rowIndex);
    }
}
