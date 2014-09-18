import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Given an iterator
 * 1 2 3 4 5 6 7 8 9 -> 1 3 5 7 9
 */
class JumpIterator<T> implements Iterator<T> {

    private Iterator<T> iter;

    JumpIterator(Iterator<T> iter) {
        this.iter = iter;
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public T next() {
        T curElem = iter.next();
        if (hasNext()) iter.next();
        return curElem;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

public class Solution {
    public static void main(String[] args) {
        JumpIterator<Integer> jumpIterator = new JumpIterator<Integer>(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)).iterator());
        while (jumpIterator.hasNext()) {
            System.out.println(jumpIterator.next());
        }
    }
}
