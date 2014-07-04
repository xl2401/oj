/*
 * 5.5
 * # of bit to flip to change a to b
 */
public class BitToConvert {
    public static final int LEN_OF_INT = 32;

    public int numOfBitToConvert(int a, int b) {
        int c = a ^ b;
        // count # of ones in c
        int res = 0;
        for (int i = 0; i < LEN_OF_INT; i++) {
            int mask = 1 << i;
            if ((c & mask) != 0) res++;
        }
        return res;
    }

    // better version
    public int numOfBitToConvertBetter(int a, int b) {
        int cnt = 0;
        //---------------------------------
        // [Important Conclusion] c & (c-1) clear the least significant bit
        // e.g. 1101 -> 1100
        //      1010 -> 1000
        //      1000 -> 0000
        for (int c = a ^ b; c != 0; c = c & (c-1)) {
            cnt++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new BitToConvert().numOfBitToConvert(31, 14));
    }
}
