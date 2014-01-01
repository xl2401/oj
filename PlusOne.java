public class PlusOne {
    public int[] plusOne(int[] digits) {
        int N = digits.length;
        boolean c = false;
        for (int i = N-1; i >= 0; i--){
            if (i == N-1){
                digits[i] += 1;
            }
            if (c){
                digits[i] += 1;
            }
            if (digits[i] >= 10){
                digits[i] -= 10;
                c = true;
            }
            else{
                c = false;
            }
        }
        if (c){
            int[] newDigits = new int[N+1];
            newDigits[0] = 1;
            for (int i = 0; i < N; i++){
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        }
        else{
            return digits;
        }
    }
}
