import java.util.ArrayList;
import java.util.Iterator;

/*
 * 5.7
 * Find the missing num of the giving list, the list contains # from 0 to n except one #
 * [CONSTRAINT] we cannot access the whole # at once, we can only access one of its bit at once
 *
 * Solution:
 * this is iterative solution
 * see P.255 for recursive solution
 */
public class MissingNum {
    public int findMissing(ArrayList<Integer> numList) {
        int res = 0;
        int base = 1;
        int idx = 0;
        while (numList.size() != 0) {
            int oneCnt = getOneCnt(numList, idx);
            int zeroCnt = numList.size() - oneCnt;
            if (zeroCnt <= oneCnt) {
                // 0 removed, remove all 1 from the list
                rmAtIdx(numList, idx, 1);
            } else {
                // 1 removed, remove all 0 from the list
                rmAtIdx(numList, idx, 0);
                // update res
                res += base;
            }
            base <<= 1;
            idx++;
        }
        return res;
    }

    // remove from numList if val at idx is [val]
    private void rmAtIdx(ArrayList<Integer> numList, int idx, int val) {
        Iterator<Integer> iter = numList.iterator();
        while (iter.hasNext()) {
            if (getBit(iter.next(), idx) == val) {
                iter.remove();
            }
        }
    }

    // get cnt of 1s on idx
    private int getOneCnt(ArrayList<Integer> numList, int idx) {
        int cnt = 0;
        for (Integer num: numList) {
            if (getBit(num, idx) == 1)
                cnt++;
        }
        return cnt;
    }

    // get bit value on idx
    public int getBit(int val, int idx) {
        return (val & (1 << idx)) != 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < 14; i++) {
            numList.add(i);
        }
        numList.remove(new Integer(3));
        System.out.println(new MissingNum().findMissing(numList));
    }
}
