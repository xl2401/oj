public class Solution {
    public void merge(int A[], int m, int B[], int n) {
    	int ptr = m + n - 1;
    	int aPtr = m - 1;
    	int bPtr = n - 1;
    	while (ptr >= 0) {
    		if (aPtr >= 0 && bPtr >= 0) {
        		if (A[aPtr] < B[bPtr]) {
        			A[ptr--] = B[bPtr--];
        		} else {
        			A[ptr--] = A[aPtr--];
        		}
        	} else if (bPtr >= 0) {
        		A[ptr--] = B[bPtr--];
        	} else {
        	    break;
        	}
    	}
    }
}