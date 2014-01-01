public class StrStr {
    public boolean checkContain(char[] str1, char[] str2, int index){
        int N1 = str1.length;
        int N2 = str2.length;
        if ((index + N2) > N1){
            return false;
        } 
        else{
            boolean contain = true;
            for (int i = 0; i < N2; i++){
                if (str1[index + i]  != str2[i]){
                    contain = false;
                    break;
                }
            }
            return contain;
        }
    }
    
    public String strStr(String haystack, String needle) {
        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();
        int N1 = str1.length;
        int N2 = str2.length;
        if (N1 == 0 && N2 == 0){
            return "";
        }
        if (N2 > N1) return null;
        int index = -1;
        for (int i = 0; i < N1; i++){
            if (checkContain(str1, str2, i)){
                index = i;
                break;
            }
        }
        if (index == -1){
            return null;
        }
        else{
            return haystack.substring(index);
        }
    }
}
