package main;

import java.util.Arrays;
import java.util.Comparator;
/**
 * ArrayList.Not thread safe.
 *
 * @param <E> Type of elements.
 */
public class DIYArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;



    /**
     * Constructor without params.
     */
    public DIYArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     *  Add an element to the end of the List.
     *
     * @param element The element we are adding.
     */
    public void add(E element) {
        if (size == elements.length) {
            doubleCapacity();
        }
        elements[size++] = element;
    }

    /**
     * Add an element to specific index.
     *
     * @param index   Specific index.
     * @param element An element we are adding.
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index" + ": " + index + "Size" + ": " + size);
        }

        if (size == elements.length) {
            doubleCapacity();
        }

        // Moove elements to the right, beginning from the end of the List.
        System.arraycopy(elements,
                index,
                elements,
                index + 1,
                size - index);
        // Paste new element to the released place.
        elements[index] = element;
        // Increase the size of the List.
        size++;
    }



    /**
     * Get element by it's index.
     *
     * @param index Element's index.
     * @return Element by index.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index" + ": " + index + "Size" + ": " + size);
        }
        return (E) elements[index];
    }



    /**
     * Sorting elements of the List in natural order.
     */
    public void sort() {
        sort(null);
    }


    /**
     * Sorting elements using Comparator.
     *
     * @param comparator Comparator to get the needed order of elements.
     */
    public void sort(Comparator<? super E> comparator) {
        if (comparator == null) {
            Arrays.sort(elements, 0, size);
        } else {
            Arrays.sort((E[]) elements, 0, size, comparator);
        }
    }

    /**
     * Delete element by it's index.
     *
     * @param index Index of an element we are deleting.
     * @return Deleted element.
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index" + ": " + index + "Size" + ": " + size);
        }

        E removedElement = (E) elements[index];

        // Moove elements to the left,beginning from the element that stands after deleted element.
        System.arraycopy(
                elements, index + 1,
                elements, index, size - index - 1);

        // Clear the last element and reduse the size of the List.
        elements[--size] = null;

        return removedElement;
    }

    /**
     * Clear the whole collection.
     */
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }


    /**
     * Double capacity.
     */
    private void doubleCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    /**
     * Return quantity of elements in the list.
     *
     * @return size of the list.
     */
    public int size() {
        return size;
    }

}
