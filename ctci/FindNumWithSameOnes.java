/*
 * 5.3
 * find the smaller or larger number with the same cnt of 1s in binary presentation
 */
public class FindNumWithSameOnes {
    public static final int SIZE_OF_INT = 32;

    // instead of maintain status
    // we can also find 0 and maintain 1 cnt
    // once we find 0 and onecnt > 0 -> do it!
    public int findLarger(int val) {
        int prevState = 0;
        int i = 0;
        int oneCnt = 0;
        for (; i < SIZE_OF_INT; i++) {
            int curState = getBit(val, i);
            if (curState == 1) oneCnt++;
            if (prevState == 1 && curState == 0) {
                break;
            }
            prevState = curState;
        }
        if (i == SIZE_OF_INT) return -1;
        // set ith to 1
        val |= 1 << i;
        // clear idx 0 til i-1
        int maskClear = ~((1 << i) - 1);
        // set lowest oneCnt-1 to one
        return val & maskClear | (1 << (oneCnt - 1) - 1);
    }

    public int findSmaller(int val) {
        int prevState = 1;
        int i = 0;
        int oneCnt = 0;
        for (; i < SIZE_OF_INT; i++) {
            int curState = getBit(val, i);
            if (curState == 1) oneCnt++;
            if (prevState == 0 && curState == 1) {
                break;
            }
            prevState = curState;
        }
        if (i == SIZE_OF_INT) return -1;
        // put all 1 from idx 0 -> i to the front
        int mask = ((1 << oneCnt) - 1) << (i - oneCnt);
        // clear bits from idx 0 to i
        int maskClear = ~((1 << (i + 1)) - 1);
        return (maskClear & val) | mask;
    }

    private int getBit(int val, int idx) {
        return ((1 << idx) & val) == 0 ? 0 : 1;
    }

    public static void main(String[] args) {
        System.out.println(new FindNumWithSameOnes().findLarger(6));
        System.out.println(new FindNumWithSameOnes().findSmaller(9));
    }
}
