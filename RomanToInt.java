import java.util.HashMap;

public class RomanToInt {
    public int romanToInt(String s) {
        HashMap<Character, Integer> numStrMap = new HashMap<Character, Integer>();
        numStrMap.put('I', 1);
        numStrMap.put('V', 5);
        numStrMap.put('X', 10);
        numStrMap.put('L', 50);
        numStrMap.put('C', 100);
        numStrMap.put('D', 500);
        numStrMap.put('M', 1000);
        int sum = 0;
        int i = 0;
        while (i < s.length()){
            int current = numStrMap.get(s.charAt(i));
            if (i+1 < s.length()){
                int next = numStrMap.get(s.charAt(i+1));
                if (current < next){
                    sum += next - current;
                    i++;
                }
                else sum += current;
                i++;
            }
            else{
                sum += current;
                i++;
            }
        }
        return sum;
    }
}
