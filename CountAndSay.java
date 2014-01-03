public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String prevStr = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prevStr.length(); i++){
            int count = getCount(prevStr, i);
            sb.append(count);
            sb.append(prevStr.charAt(i));
            i += count - 1;
        }
        return sb.toString();
    }

    public int getCount(String s, int i){
        char c = s.charAt(i);
        int count = 1;
        i++;
        while (i < s.length() && s.charAt(i) == c){
            count++;
            i++;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(new CountAndSay().countAndSay(5));
    }
}
