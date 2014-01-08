import java.util.ArrayList;

/**
 * Title: Pow(x, n) 
 * Description:
 * Implement pow(x, n).
 *
 * Solution:
 * Transform n into binary form
 * pre calculate x^(2^0), x^(2^1), x^(2^2)...
 */
public class Pow {
    public double pow(double x, int n) {
        boolean reverse = false;
        if (x == 1) return 1;
        if (n < 0){
            n = -1 * n;
            reverse = true;
        }
        ArrayList<Boolean> binArray = getBinArray(n);
        int N = binArray.size();
        if (N == 0) return 1;
        double[] powDict = new double[N];
        powDict[0] = x;
        for (int i = 1; i < N; i++){
            powDict[i] = powDict[i-1] * powDict[i-1];
        }
        double pow = 1;
        for (int i = 0; i < N; i++){
            if (binArray.get(i))
                pow *= powDict[i];
        }
        if (reverse) pow = 1 / pow;
        return pow;
    }

    /**
     * Transform n into bin array
     * from the least significant bit to the most significant bit
     */
    public ArrayList<Boolean> getBinArray(int n){
        ArrayList<Boolean> binArray = new ArrayList<Boolean>();
        while (n > 0){
            int remainder = n % 2;
            binArray.add(remainder == 1);
            n /= 2;
        }
        return binArray;
    }

    public static void main(String[] args){
        Pow p = new Pow();
        System.out.println(p.pow(2, 2));
        System.out.println(p.pow(2, 3));
        System.out.println(p.pow(2, -3));
        System.out.println(p.pow(-3, 3));
        System.out.println(p.pow(-3, 0));
        System.out.println(p.pow(1, -2147483648));
    }
}
