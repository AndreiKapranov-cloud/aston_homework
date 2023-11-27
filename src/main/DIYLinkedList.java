package main;

import java.util.Comparator;

/**
 * Simple realization of singly linked list.
 *
 * @param <E> Type of elements in linked list.
 */
public class DIYLinkedList<E> {

    // Inner class representing a node of the linked list.
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    // Head element of the linked list.
    private Node<E> head;

    // Number of elements in the list.
    private int size;


    /**
     * Add element to the end of the list.
     *
     * @param element Element we are adding.
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * Adding element to needed index.
     *
     * @param index   Place,where we insert the element.
     * @param element Element to add.
     * @throws IndexOutOfBoundsException if the index is out of the list boundary.
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Wrong index" + ": " + index);
        }

        Node<E> newNode = new Node<>(element);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> previous = getNode(index - 1);
            newNode.next = previous.next;
            previous.next = newNode;
        }
        size++;
    }

    // Helper method to get the node by index.
    private Node<E> getNode(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Get element by index.
     *
     * @param index Index of the element in the list.
     * @return Element of the list.
     * @throws IndexOutOfBoundsException if index reaches out of the list boundary.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index" + ": " + index);
        }

        return getNode(index).data;
    }

    /**
     * Delete element by index.
     *
     * @param index Index of the element to delete.
     * @return Deleted element.
     * @throws IndexOutOfBoundsException If the index reaches out of the list boundary.
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index" + ": " + index);
        }

        Node<E> removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else {
            //connecting the previous node with the next node of the deleted element.
            Node<E> previous = getNode(index - 1);
            removedNode = previous.next;
            previous.next = removedNode.next;
        }

        size--;
        return removedNode.data;
    }

    /**
     * Clear the whole list.
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Sort the list with the help of comparator.
     *
     * @param comparator Comparator to compare the elements.
     */
    public void sort(Comparator<? super E> comparator) {
        // Insertion sort
        // Iterate over elements of the list
        for (Node<E> i = head; i != null; i = i.next) {
            // Compare current element with the next
            for (Node<E> j = i.next; j != null; j = j.next) {
                // If the current element is greater than the next -  we change them around.
                if (comparator.compare(i.data, j.data) > 0) {
                    E temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }
    /**
     * Return quantity of elements in the list.
     *
     * @return Quantity of elements in the list.
     */
    public int size() {
        return size;
    }

}
