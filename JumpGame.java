class JumpGame {
    private boolean[] visited;
    public boolean canJump(int[] A) {
        visited = new boolean[A.length];
        for (int i = 0; i < A.length; i++){
            visited[i] = false;
        }
        return canJump(A, 0);
    }

    public boolean canJump(int[] A, int idx){
        if (idx >= A.length-1) return true;
        else{
            if (A[idx] == 0) return false;
            else{
                visited[idx] = true;
                boolean result = false;
                for (int i = A[idx]; i >= 1; i--){
                    if (idx+i < A.length && !visited[idx+i])
                        result = result || canJump(A, idx+i);
                }
                return result;
            }
        }
    }

    public static void main(String[] args){
        int[] A = new int[1305];
        for (int i = 0; i < 1305; i++){
            A[i] = 25000 - i;
        }
        System.out.println(new JumpGame().canJump(A));
    }
}
