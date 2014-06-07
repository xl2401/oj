import java.util.Arrays;

/*
 * 1.4
 * Replace space in an char array into %20, assume the char array has enough space
 * use ptr to simplify idx calculation
 */
public class ReplaceSpace {
    public int replaceSpace(char[] str, int size) {
        int spaceCnt = 0;
        for (int i = 0; i < size; i++) {
            if (str[i] == ' ')
                spaceCnt++;
        }
        int newSize = size + spaceCnt * 2;
        // ptr is the end of the original str
        int ptr = size - 1;
        // targetPtr is the end of the targetStr
        int targetPtr = newSize - 1;
        while (ptr >= 0) {
            if (str[ptr] == ' ') {
                ptr--;
                str[targetPtr--] = '0';
                str[targetPtr--] = '2';
                str[targetPtr--] = '%';
            }
            else {
                str[targetPtr--] = str[ptr--];
            }
        }
        return newSize;
    }

    public static void main(String[] args) {
        String s = "ab cd ee   ";
        char[] str = Arrays.copyOf(s.toCharArray(), 100);
        int newSize = new ReplaceSpace().replaceSpace(str, s.length());
        str = Arrays.copyOf(str, newSize);
        System.out.println(new String(str));
    }
}
