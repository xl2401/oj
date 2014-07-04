/*
 * 5.6
 * Swap the bit on even idx and odd idx
 */
public class SwapOddEvenBit {
    public int swapBit(int a) {
        int oddMask = 0;
        int evenMask = 0;
        for (int i = 0; i < 32; i++) {
            if (i % 2 == 0) {
                oddMask |= 1 << i;
            } else {
                evenMask |= 1 << i;
            }
        }
        int oddBits = a & oddMask;
        int evenBits = a & evenMask;
        // consider carefully whether it's & or |
        return (oddBits << 1) | (evenBits >> 1);
    }

    // use magic number to construct oddMask and evenMask
    public int swapBitMagic(int a) {
        // 1010 1010 1010 ...
        // 0101 0101 0101 ...
        return ((a & 0xaaaaaaaa) >> 1) | ((a & 0x55555555) << 1);
    }

    public static void main(String[] args) {
        System.out.println(new SwapOddEvenBit().swapBitMagic(5));
    }
}
