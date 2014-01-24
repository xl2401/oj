import java.util.ArrayList;

/*
 * Title: Restore IP Addresses 
 * Description:
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 * Solution:
 * Very naive method, use for loop to check validity
 */
public class RestoreIP {
    public ArrayList<String> restoreIpAddresses(String s) {
        int N = s.length();
        ArrayList<String> result = new ArrayList<String>();
        // obviously not possible answer
        if (N > 12)
            return result;
        for (int i = 1; i < N-2; i++){
            for (int j = i+1; j < N-1; j++){
                for (int k = j+1; k < N; k++){
                    if (legal(s, 0, i) && legal(s, i, j) && legal(s, j, k) && legal(s, k, N)){
                        String ip = s.substring(0, i) + "." + s.substring(i, j) + "." + s.substring(j, k)
                             + "." + s.substring(k, N);
                        result.add(ip); 
                    }
                }
            }
        }
        return result;
    }

    public boolean legal(String s, int start, int end){
        if ((end - start) > 3)
            return false;
        // special occasion, leading '0', e.g. 0110 is not valid
        if ((end - start) > 1 && s.charAt(start) == '0')
            return false;
        int sum = 0;
        for (int i = start; i < end; i++){
            sum *= 10;
            sum += s.charAt(i) - '0';
        }
        if (sum > 255)
            return false;
        else
            return true;
    }

    public static void main(String[] args){
        RestoreIP rip = new RestoreIP();
        ArrayList<String> result = rip.restoreIpAddresses("010010");
        for (String str: result){
            System.out.println(str);
        }
    }
}
