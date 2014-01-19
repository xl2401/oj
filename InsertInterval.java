import java.util.ArrayList;
import java.util.Iterator;

/*
 * Title: Insert Interval 
 * Description:
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Solution:
 * Horrible solution here, look for simpler method...
 */
public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int N = intervals.size();
        // special occasion
        if (N == 0){
            intervals.add(newInterval);
            return intervals;
        }
        else{
            int min = intervals.get(0).start;
            int max = intervals.get(N-1).end;
            if (newInterval.end < min){
                intervals.add(0, newInterval);
                return intervals; 
            }
            else if(newInterval.start > max){
                intervals.add(newInterval);
                return intervals;
            }
        }

        int startIdx = -1;
        boolean startCover = false;
        for (int i = 0; i < N; i++){
            int newStart = newInterval.start;
            Interval curInter = intervals.get(i);
            if (newStart < curInter.start){
                startCover = true;
                startIdx = i;
                break;
            }
            if (newStart >= curInter.start && newStart <= curInter.end){
                startCover = false;
                startIdx = i;
                break;
            }
        }

        int endIdx = -1;
        boolean endCover = false;
        for (int i = startIdx; i < N; i++){
            int newEnd = newInterval.end;
            Interval curInter = intervals.get(i);
            if (newEnd >= curInter.start && newEnd <= curInter.end){
                endCover = false;
                endIdx = i;
                break;
            }
            if (i == N-1 || intervals.get(i+1).start > newInterval.end){
                endCover = true;
                endIdx = i;
                break;
            }
        }
        if (startIdx == endIdx && newInterval.end < intervals.get(startIdx).start){
            intervals.add(startIdx, newInterval);
            return intervals;
        }

        int lStart = intervals.get(startIdx).start;
        int rEnd = intervals.get(endIdx).end;
        if (startCover)
            lStart = newInterval.start;
        if (endCover)
            rEnd = newInterval.end;
        Iterator<Interval> iter = intervals.iterator();
        int interCount = 0;
        while (iter.hasNext()){
            Interval inter = iter.next();
            if (interCount >= startIdx && interCount <= endIdx){
                iter.remove();
            }
            interCount++;
        }
        intervals.add(startIdx, new Interval(lStart, rEnd));
        return intervals;
    }

    public static void main(String[] args){
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(12,15));
        InsertInterval ii = new InsertInterval();
        ArrayList<Interval> result = ii.insert(intervals, new Interval(6,6));
        for (Interval inter: result){
            System.out.println(inter.start + " " + inter.end);
        }
    }
}
