public class SearchInsertPos {
    public int searchInsert(int[] A, int target) {
        return searchInsert(A, 0, A.length-1, target);
    }

    public int searchInsert(int[] A, int start, int end, int target){
        if (start <= end){
            int mid  = (start + end) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > target) return searchInsert(A, start, mid-1, target);
            else return searchInsert(A, mid+1, end, target);
        }
        else return start;
    }

    public static void main(String[] args){
        int[] A = {1, 3, 5, 6};
        SearchInsertPos sip = new SearchInsertPos();
        System.out.println(sip.searchInsert(A, 5));
        System.out.println(sip.searchInsert(A, 2));
        System.out.println(sip.searchInsert(A, 7));
        System.out.println(sip.searchInsert(A, 0));
    }
}
