public class ZigZag {
    public String convert(String s, int nRows) {
        if (nRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int N = s.length();
        
        int add1 = 2 * nRows - 4;
        int add2 = 2;
        for (int i = 0; i < nRows; i++){
            if (i == 0 || i == (nRows-1)){ // First row or last row
                int pointer = i;
                while (true){
                    if (pointer < N){
                        sb.append(s.charAt(pointer));
                        pointer += 2 * nRows - 2;
                    }
                    else break;
                }
            }
            else{ // Middle zig zag
                int pointer = i;
                int j = 0;
                while (true){
                    if (pointer < N){
                        sb.append(s.charAt(pointer));
                        if (j % 2 == 0) pointer += add1;
                        else pointer += add2;
                        j++;
                    }
                    else break;
                }
                add1 -= 2;
                add2 += 2;
            }
        }
        return sb.toString();
    }
}
