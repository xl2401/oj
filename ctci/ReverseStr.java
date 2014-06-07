/*
 * 1.2
 * Reverse a string
 * using swap
 */
public class ReverseStr{
    private void swap(char[] charArray, int i, int j){
        char tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
    }

    public String reverseStr(String str){
        char[] charArray = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++){
            int j = str.length() - 1 - i;
            swap(charArray, i, j);
        }
        return new String(charArray);
    }

    public static void main(String[] args){
        String str = "abcde";
        String rev = new ReverseStr().reverseStr(str);
        System.out.println(str);
        System.out.println(rev);
    }
}
