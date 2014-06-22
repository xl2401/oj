/*
 * 3.4
 * Hanoi
 *
 * Recursive
 */
public class Hanoi {
    private int cnt;

    public Hanoi(int cnt) {
        this.cnt = cnt;
    }

    private void mv(int idx, int from, int to, int via) {
        if (idx > 0) {
            mv(idx-1, from, via, to);
            System.out.println(String.format("move disk %d from %d to %d", idx, from, to));
            mv(idx-1, via, to, from);
        }
    }

    public void mv() {
        mv(cnt, 0, 2, 1);
    }

    public static void main(String[] args) {
        Hanoi h = new Hanoi(3);
        h.mv();
    }
}
