/*
 * 5.2
 * Present a double from 0 to 1 in binary string
 *
 * solution:
 * move left to test if larger or equal to 1
 */
public class Binary {
    public void printBinary(double n) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        double minus = 0.5;
        while (n != 0) {
            if (n >= minus) {
                n -= minus;
                sb.append('1');
            } else {
                sb.append('0');
            }
            minus /= 2;
            if (sb.length() == 32 && n != 0) {
                System.out.println("ERROR");
                return;
            }
        }
        System.out.println(sb.toString());
    }

    public String printBinary2(double n) {
        if (n < 0 || n > 1) return "ERROR";
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (n > 0) {
            if (sb.length() >= 32)
                return "ERROR";
            n *= 2;
            // larger or **equal to** 1
            if (n >= 1) {
                sb.append(1);
                n -= 1;
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String bin = new Binary().printBinary2(0.5625);
        System.out.println(bin);
    }
}
