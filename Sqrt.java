public class Sqrt {
    public int sqrt(int x) {
        // binary search
        double left = 0;
        double right = x;
        while (left < right){
            double mid = (left + right) / 2;
            if ((int)mid == (int)(x/ mid)) return (int)mid;
            if (mid > (x/mid)){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        return (int)left;
    }
}
