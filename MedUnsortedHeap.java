import java.util.PriorityQueue;
import java.util.Collections;
/*
 * Title: Median of Unsorted Array
 * (Not in leetcode)
 * Description:
 *
 * Solution:
 * Use a max-heap and a min-heap,
 * the max-heap store the former smaller half, the min heap store the latter larger half
 * keep add num into the min heap til it's full,
 * and remove its top(poll) and add more num to it. The top is put into the max-heap
*/
public class MedUnsortedHeap{
   public double med(int[] A){
       int N = A.length;
       int minSize = N / 2;
       int maxSize = N - minSize;
       int minCount = 0;
       PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(maxSize, 
               Collections.reverseOrder());
       PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(minSize);
       for (int i = 0; i < N; i++){
           if (minCount < minSize){
               minHeap.add(A[i]);
           }
           else{
               int top = minHeap.poll();
               maxHeap.add(top);
               minHeap.add(A[i]);
           }
       }
       if (N % 2 == 0){// even
           return 1.0 * (maxHeap.peek() + minHeap.peek()) / 2;
       }
       else{
           return maxHeap.peek();
       }
    }

    public static void main(String[] args){
        int[] A = {3,1,4,5,2};
        MedUnsorted mu = new MedUnsorted();
        System.out.println(mu.med(A));
    }
}
