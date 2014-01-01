import java.util.HashMap;

public class IntToRoman {
    public String intToRoman(int num) {
        HashMap<Integer, String> numStrMap = new HashMap<Integer, String>();
        numStrMap.put(1, "I");
        numStrMap.put(4, "IV");
        numStrMap.put(5, "V");
        numStrMap.put(9, "IX");
        numStrMap.put(10, "X");
        numStrMap.put(40, "XL");
        numStrMap.put(50, "L");
        numStrMap.put(90, "XC");
        numStrMap.put(100, "C");
        numStrMap.put(400, "CD");
        numStrMap.put(500, "D");
        numStrMap.put(900, "CM");
        numStrMap.put(1000, "M");
        int[] numKey = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (Integer key: numKey){
            int count = num / key;
            num -= count * key;
            for (int i = 0; i < count; i++){
                sb.append(numStrMap.get(key));
            }
        }
        return sb.toString();
    }
}
