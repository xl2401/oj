public class NextPermu {
    public void nextPermutation(int[] num) {
        int N = num.length;
        int idx = N - 1;
        while (idx >= 1 && num[idx] <= num[idx-1]){
            idx--;
        }
        if (idx == 0){// reverse oreder
            reverse(0, N-1, num);
            return;
        }
        else{
            // find the exchange index
            int exIdx;
            for (exIdx = N-1; exIdx >= idx; exIdx--){
                if (num[exIdx] > num[idx-1]) break;
            }
            swap(num, exIdx, idx-1);
            reverse(idx, N-1, num);
        }
    }

    public void reverse(int i, int j, int[] num){
        while (i < j){
            swap(num, i++, j--);
        }
    }

    public void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args){
        int[] num = {1,2,7,5,4,3,2,1};
        new NextPermu().nextPermutation(num);
        for (int i = 0; i < num.length; i++){
            System.out.println(num[i]);
        }
    }
}
