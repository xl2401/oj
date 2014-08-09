import java.util.List;
import java.util.ArrayList;

public class GrayCode {
    public List<Integer> grayCode(int n) { 
        List<Integer> res = new ArrayList<Integer>();
        if (n == 0) return res;
        if (n == 1) {
            res.add(0);
            res.add(1);
            return res;
        }
        List<Integer> lastRes = grayCode(n-1);
        int N = lastRes.size();
        for (int i = N-1; i >= 0; i--) {
            lastRes.add(lastRes.get(i) + (int)Math.pow(2, n-1));
        }
        return lastRes;
    }

    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        List<Integer> res = gc.grayCode(4);
        for (Integer i: res) {
            System.out.println(i);
        }
    }
}
