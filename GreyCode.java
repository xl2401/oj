import java.util.ArrayList;
import java.util.Arrays;

public class GreyCode {
    public ArrayList<Integer> grayCode(int n) {
        if (n == 1) return new ArrayList<Integer>(Arrays.asList(0, 1));
        if (n == 0) return new ArrayList<Integer>(Arrays.asList(0));
        ArrayList<Integer> result = grayCode(n-1);
        int N = result.size();
        for (int i = N-1; i >= 0; i--){
            result.add(result.get(i) + (int)Math.pow(2, n-1));
        }
        return result;
    }

    public static void main(String[] args){
        ArrayList<Integer> result = new GreyCode().grayCode(2);
        for (Integer i: result){
            System.out.println(i);
        }
    }
}
