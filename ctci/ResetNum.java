/*
 * 5.1
 * Set M to N from bit idx i to j
 * e.g. N = 10000000000
 *      M = 10011
 *      i = 2 j = 6
 * return N = 10001001100
 *
 * Solution:
 * first clear the updated part
 * then set
 */
public class ResetNum {
    public int reset(int N, int M, int i, int j) {
        int len = j - i + 1;
        // mask 11111111110000111111 to clear the 0 part
        int mask = ~(((1 << len) - 1) << i);
        N &= mask;
        // set M
        return N | (M << i);
    }
}
