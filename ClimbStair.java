public class ClimbStair {
    public int climbStairs(int n) {
        int prevCount1 = 1;
        int prevCount2 = 2;
        if (n == 1) return prevCount1;
        if (n == 2) return prevCount2;
        int currentCount = 0;
        for (int i = 3; i <= n; i++){
            currentCount = prevCount1 + prevCount2;
            prevCount1 = prevCount2;
            prevCount2 = currentCount;
        }
        return currentCount;
    }

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        System.out.println(new ClimbStair().climbStairs(n));
    }
}
