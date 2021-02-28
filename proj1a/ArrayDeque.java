public class ArrayDeque<T> {
    T[] items;
    int nextFirst;
    int nextLast;
    int size;
    private static final int initCapacity = 8;
    private static final int refactor = 2;
    private static final double minUseRatio = 0.25;


    public ArrayDeque() {
        items = (T[]) new Object[initCapacity];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        T[] newItems = (T[]) new Object[initCapacity];
        nextFirst = 4;
        nextLast = 5;
        size = 0;

        for (int i = 0; i < other.size; i += 1) {
            addLast((T) other.get(i));
        }
    }

    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        int curr = plusOne(nextFirst);
        for (int i = 0; i < size; i += 1) {
            newArray[i] = items[curr];
            curr = plusOne(curr);
        }
        items = newArray;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * refactor);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * refactor);
        }
        items[nextLast] = item;
        size += 1;
        nextFirst = plusOne(nextLast);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {

        int i = plusOne(nextFirst);
        while (i != nextLast) {
            System.out.print(items[i] + " ");
            i = plusOne(i);
        }
        System.out.println();
    }

    public T removeFirst() {

        if (size == 0) {
            return null;
        }

        int first = plusOne(nextFirst);
        T firstItem = items[first];
        items[first] = null;
        nextFirst = first;
        size -= 1;

        if (items.length >= 16 && size < items.length * minUseRatio) {
            resize(items.length / 2);
        }

        return firstItem;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int last = minusOne(nextLast);
        T lastItem = items[last];
        items[last] = null;
        nextLast = last;
        size -= 1;

        if (items.length >= 16 && size <= items.length * minUseRatio) {
            resize(items.length / 2);
        }

        return lastItem;
    }

    public T get(int index) {
        if (index > size) {
            return null;
        }
        index = (plusOne(nextFirst) + index) % items.length;
        return items[index];
    }
}
