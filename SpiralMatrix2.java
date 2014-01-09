/*
 * Title: Spiral Matrix II 
 * Description:
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Solution:
 * The tricky part is to get the corresponding index, extract this part into Indexer
 */
public class SpiralMatrix2 {
    class SpiralIndexer{
        private int N = 0;
        private int layer = 0;
        private int dir = 0;
        private int i = 0;
        private int j = -1;

        public SpiralIndexer(int n){
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
                if (i == N-layer){// out of bound, go left
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

    public int[][] generateMatrix(int n) {
        int[][] A = new int[n][n];
        SpiralMatrix2 sm = new SpiralMatrix2();
        SpiralIndexer si = sm.new SpiralIndexer(n);
        for (int i = 0; i < n*n; i++){
            int[] index = si.next();
            A[index[0]][index[1]] = i+1;
        }
        return A;
    }

    public static void main(String[] args){
        int[][] A = new SpiralMatrix2().generateMatrix(4);
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
