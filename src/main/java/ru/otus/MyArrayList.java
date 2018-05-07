package ru.otus;

import java.util.*;


public class MyArrayList<T> implements Collection<T>
{
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    protected transient int modCount = 0;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else if (capacity == 0) {
            this.elements = new Object[0];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    capacity);
        }
    }

    public MyArrayList() {
        this.elements = new Object[0];
    }

    public int size() {
        return this.elements.length;
    }

    public boolean isEmpty() {
        //return false;
        throw new RuntimeException("Not supported.");
    }

    public boolean contains(Object o) {
        //return false;
        throw new RuntimeException("Not supported.");
    }

    public Iterator<T> iterator() {
        //return null;
        throw new RuntimeException("Not supported.");
    }

    public <T1> T1[] toArray(T1[] a) {
        //return null;
        throw new RuntimeException("Not supported.");
    }

    public boolean add(T t) {
        //return false;
        throw new RuntimeException("Not supported.");
    }

    public boolean remove(Object o) {
        //return false;
        throw new RuntimeException("Not supported.");
    }

    public boolean containsAll(Collection<?> c) {
        //return false;
        throw new RuntimeException("Not supported.");
    }
    @SuppressWarnings("unchecked")
    public MyArrayList<T>  clone() {
        try {
            MyArrayList<T> dest = new MyArrayList<T>();
            dest.addAll(this);
            return dest;
        } catch (RuntimeException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }
    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size + numNew);  // Increments modCount
        System.arraycopy(a, 0, elements, size, numNew);
        size += numNew;
        return numNew != 0;
    }
    private void ensureCapacityInternal(int minCapacity) {
        if (elements ==  new Object[0]) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elements.length > 0)
            grow(minCapacity);
    }
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);// увеличиваем на 50%

        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;

        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);

        // minCapacity is usually close to size, so this is a win:
        elements = Arrays.copyOf(elements, newCapacity);
    }
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }
    public boolean removeAll(Collection<?> c) {
        //return false;
        throw new RuntimeException("Not supported.");
    }

    public boolean retainAll(Collection<?> c) {
        //return false;
        throw new RuntimeException("Not supported.");
    }

    public void clear() {
        throw new RuntimeException("Not supported.");
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                ", modCount=" + modCount +
                '}';
    }

    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super T> c) {
        final int expectedModCount = modCount;
        Arrays.sort((T[]) elements, 0, size, c);
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        modCount++;
    }
}