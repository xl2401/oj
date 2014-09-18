import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator with the following visiting sequence:
 * [[1,2,3],[4,5,6], [7,8]] -> [1,4,7,2,5,8,3,6]
 * the constructor is list of iterators.
 */
public class RotateIterator<T> implements Iterator<T>{
    private List<Iterator<T>> lists;
    private int listIdx = -1;
    private boolean reachEnd = false;

    public RotateIterator(List<Iterator<T>> lists) {
        this.lists = lists;
    }

    @Override
    public boolean hasNext() {
        if (reachEnd) return false;
        boolean has = false;
        for (Iterator<T> iter: lists) {
            if (iter.hasNext()) {
                return true;
            }
        }
        reachEnd = true;
        return false;
    }

    @Override
    public T next() {
        if (hasNext()) {
            while (true) {
                listIdx = (listIdx + 1) % lists.size();
                Iterator<T> curIter = lists.get(listIdx);
                if (curIter.hasNext()) {
                    return curIter.next();
                }
            }
        } else {
            return null;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
