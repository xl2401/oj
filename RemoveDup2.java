/*
 * Title:
 * Description:
 * The array is sorted,
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * Solution:
 * add curDup count
 * Note: when curDup == 1, we still need to copy the number to former position
 */
public class RemoveDup2 {
    public int removeDuplicates(int[] A) {
        int dupCount = 0;
        int curDup = 0;
        for (int i = 1; i < A.length; i++){
            if (A[i] == A[i-1]){
                curDup++;
                if (curDup > 1)
                    dupCount++;
                else
                    A[i-dupCount] = A[i];
            }
            else{
                curDup = 0;
                A[i-dupCount] = A[i];
            }
        }
        return A.length - dupCount;
    }

    public static void main(String[] args){
        int[] A = {1,1,1,1,3,3};
        int count = new RemoveDup2().removeDuplicates(A);
        System.out.println(count);
        for (int i = 0; i < count; i++){
            System.out.println(A[i]);
        }
    }
}
