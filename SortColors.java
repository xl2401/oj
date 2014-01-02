public class SortColors {
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public void sortColors(int[] A) {
        int i = 0;
        int j = A.length-1;
        int cur = 0;
        while (cur < j+1){ // max value of cur should be j
            if (A[cur] == 0){
                swap(A, i++, cur++);
                continue;
            }
            if (A[cur] == 2){
                swap(A, j--, cur);
                continue;
            }
            cur++;
        }
    }

    public static void main(String[] args){
        int[] A = {0, 0, 0, 1, 2, 0, 0, 1, 2};
        new SortColors().sortColors(A);
        for (int i = 0; i < A.length; i++){
            System.out.println(A[i]);
        }
    }
}
