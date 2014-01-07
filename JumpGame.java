class JumpGame {
    public boolean canJump(int[] A) {
        int N = A.length;
        int maxReach = 0;
        for (int i = 0; i < N-1; i++){
            if (i > maxReach) return false;
            else{
                int stepSize = A[i];
                maxReach = Math.max(maxReach, i + stepSize);
                if (maxReach >= N-1) return true;
            }
        }
        if (maxReach >= N-1) return true;
        else return false;
    }

    public static void main(String[] args){
        int[] A = {3,2,1,0,4};
        System.out.println(new JumpGame().canJump(A));
    }
}
