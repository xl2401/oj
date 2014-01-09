import java.util.ArrayList;

/*
 * Title: Spiral Matrix 
 * Description:
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Solution:
 * tricky part is to get spriral order matrix
 * extract this part into indexer
 */
public class SpiralMatrix {
    class SpiralIndexer{
        private int M = 0;
        private int N = 0;
        private int layer = 0;
        private int dir = 0;
        private int i = 0;
        private int j = -1;

        public SpiralIndexer(int m, int n){
            this.M = m;
            this.N = n;
        }

        public int[] next(){
            if (dir == 0){
                j++;
                if (j == N-layer){// out of bound, go down
                    j--;
                    dir = 1;
                    i++;
                }
            }
            else if (dir == 1){
                i++;
                if (i == M-layer){// out of bound, go left
                    i--;
                    dir = 2;
                    j--;
                }
            }
            else if (dir == 2){
                j--;
                if (j == layer-1){
                    j++;
                    dir = 3;
                    i--;
                }
            }
            else{
                i--;
                if (i == layer){
                    i++;
                    dir = 0;
                    j++;
                    layer++;
                }
            }
            int[] index = {i, j};
            return index;
        }
    }

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0
                           || matrix[0].length == 0) return result;
        int m = matrix.length;
        int n = matrix[0].length;
        SpiralMatrix sm = new SpiralMatrix();
        SpiralIndexer si = sm.new SpiralIndexer(m, n);
        for (int i = 0; i < m*n; i++){
            int[] idx = si.next();
            result.add(matrix[idx[0]][idx[1]]);
        }
        return result;
    }

    public static void main(String[] args){
        int[][] matrix = 
        {
             { 1, 2, 3 },
             { 4, 5, 6 },
             { 7, 8, 9 }
        };
        ArrayList<Integer> result = new SpiralMatrix().spiralOrder(matrix);
        for (Integer i: result){
            System.out.println(i + " ");
        }
    }
}
