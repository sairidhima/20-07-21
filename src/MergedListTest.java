import java.util.*;

public class MergedListTest {
    public static void main(String[] args) {
        testBasic();
        testEmptyA();
        testEmptyB();
    }

    private static void testBasic() {
        List<Integer> list0 = Arrays.asList(0, 1, 2);
        List<Integer> list1 = Arrays.asList(3, 4, 5);
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5);
        List<Integer> actual = new MergedList<Integer>(list0, list1);
        System.out.println(actual.equals(expected));
    }

    private static void testEmptyA() {
        List<Integer> list0 = Collections.emptyList();
        List<Integer> list1 = Arrays.asList(3, 4, 5);
        List<Integer> expected = Arrays.asList(3, 4, 5);
        List<Integer> actual = new MergedList<Integer>(list0, list1);
        System.out.println(actual.equals(expected));
    }

    private static void testEmptyB() {
        List<Integer> list0 = Arrays.asList(0, 1, 2);
        List<Integer> list1 = Collections.emptyList();
        List<Integer> expected = Arrays.asList(0, 1, 2);
        List<Integer> actual = new MergedList<Integer>(list0, list1);
        System.out.println(actual.equals(expected));
    }
}


class MergedList<T> extends AbstractList<T> {
    private final List<T> list0;
    private final List<T> list1;

    MergedList(List<T> list0, List<T> list1) {
        this.list0 = list0;
        this.list1 = list1;
    }

    @Override
    public T get(int index) {
        if (index < list0.size()) {
            return list0.get(index);
        }
        return list1.get(index - list0.size());
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<T> current = list0.iterator();
            private boolean first = true;

            @Override
            public boolean hasNext() {
                return current != null && current.hasNext();
            }

            @Override
            public T next() {
                T result = current.next();
                if (!current.hasNext()) {
                    if (first) {
                        current = list1.iterator();
                    } else {
                        current = null;
                    }
                }
                return result;
            }
        };
    }

    @Override
    public int size() {
        return list0.size() + list1.size();
    }
}