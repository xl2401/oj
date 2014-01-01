public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int[] firstColumn = new int[M];
        for (int i = 0; i < M; i++){
            firstColumn[i] = matrix[i][0];
        }
        int lineNum = getLineNum(firstColumn, target);
        if (lineNum < 0) return false;
        else{
            return binary(matrix[lineNum], target);
        }
    }
    
    public boolean binary(int[] vector, int target){
        return searchIndex(vector, 0, vector.length-1, target) >= 0 ?
            true: false;
    }
    
    public int searchIndex(int[] vector, int start, int end, int target){
        if (start <= end){
            int mid = (start + end) / 2;
            if (vector[mid] == target) return mid;
            else if(vector[mid] < target) 
                return searchIndex(vector, mid+1, end, target);
            else
                return searchIndex(vector, start, mid-1, target);
        }
        else{
            return -1;
        }
    }

    public int getLineNum(int[] vector, int target){
        int lineNum = -1;
        if (vector.length > 0 && vector[0] > target){
            return lineNum;
        }
        for (int i = 1; i < vector.length; i++){
            if (vector[i] > target){
                lineNum = i-1;
                break;
            }
        }
        if (lineNum == -1){
            lineNum = vector.length-1;
        }
        return lineNum;
    }
}
