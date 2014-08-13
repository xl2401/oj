import java.util.List;
import java.util.ArrayList;

class Indexer {
	public int M;
	public int N;
	public int layer = 0;
	public int i = 0;
	public int j = -1;
	public int dir = 0;
	public int[] xDiff = {0, 1, 0, -1};;
	public int[] yDiff = {1, 0, -1, 0};

	public Indexer(int M, int N) {
        this.M = M;
        this.N = N;
	}

	public int[] next() {
	    // change dir
	    if ((dir ==0 && j == N-layer-1) || 
	        (dir == 1 && i == M-layer-1) || 
	        (dir == 2 && j == layer) || 
	        (dir == 3 && i == layer+1)) 
	        dir = (dir + 1) % 4;
        i += xDiff[dir];
        j += yDiff[dir];
        int[] idx = {i, j};
        return idx;
    }
}

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>();
        Indexer idxer = new Indexer(M, N);
        for (int i = 0; i < M*N; i++) {
            int[] idx = idxer.next();
            int line = idx[0];
            int col = idx[1];
            res.add(matrix[line][col]);
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        List<Integer> res = sm.spiralOrder(matrix);
        for (Integer i: res) {
            System.out.println(i + " ");
        }
    }
}
