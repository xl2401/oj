public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int max = 0;
        int M = matrix.length;
        int N = matrix[0].length;
        for (int i = 0; i < M; i++) {
            int[] hist = getHeight(matrix, i);
            max = Math.max(max, maxRecHistogram(hist));
        }
        return max;
    }

    private int[] getHeight(char[][] matrix, int lineIdx) {
        int N = matrix[0].length;
        int[] hei = new int[N];
        for (int j = 0; j < N; j++) {
            int i = lineIdx;
            int height = 0;
            while (i >= 0 && matrix[i][j] == '1') {
                height++;
                i--;
            }
            hei[j] = height;
        }
        return hei;
    }

    private int maxRecHistogram(int[] hist) {
        int N = hist.length;
        hist = Arrays.copyOf(hist, N+1);
        int i = 0;
        int max = 0;
        Stack<Integer> s = new Stack<Integer>();
        while (i <= N) {
            if (s.isEmpty() || hist[s.peek()] <= hist[i]) {
                s.push(i++);
            } else {
                int calIdx = s.pop();
                max = Math.max(max, hist[calIdx] * (s.isEmpty() ? i: i-s.peek()-1));
            }
        }
        return max;
    }
}