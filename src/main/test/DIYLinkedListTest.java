package main.test;

import main.DIYLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


import static org.junit.jupiter.api.Assertions.*;

public class DIYLinkedListTest {

    private DIYLinkedList<String> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new DIYLinkedList<>();
    }

    @Test
    void shouldAddElement() {
        linkedList.add("foo");
        assertEquals(1, linkedList.size());
    }

    @Test
    void shouldAddElementByIndex() {
        linkedList.add(0, "b");
        linkedList.add(1, "a");
        linkedList.add(2, "r");

        assertEquals("b", linkedList.get(0));
        assertEquals("r", linkedList.get(2));
    }

    @Test
    void shouldGetElementByIndex() {
        linkedList.add(0, "b");
        linkedList.add(1, "a");
        linkedList.add(2, "r");
        assertEquals("b", linkedList.get(0));
        assertEquals("r", linkedList.get(2));
    }

    @Test
    void shouldRemoveElement() {
        linkedList.add(0, "b");
        linkedList.add(1, "a");
        linkedList.add(2, "r");
        String removedElement = linkedList.remove(2);
        assertEquals(2, linkedList.size());
        assertEquals("r", removedElement);
    }

    @Test
    void shouldClearList() {
        linkedList.add(0, "b");
        linkedList.add(1, "a");
        linkedList.add(2, "r");
        linkedList.clear();
        assertEquals(0, linkedList.size());
    }

    @Test
    void shouldSortListWithComparator() {
        linkedList.add(0, "bbb");
        linkedList.add(1, "aa");
        linkedList.add(2, "r");
        Comparator<String> lengthComparator = Comparator.comparing(String::length);

        linkedList.sort(lengthComparator);

        assertEquals("r", linkedList.get(0));
        assertEquals("aa",linkedList.get(1));
        assertEquals("bbb",linkedList.get(2));

    }


    @Test
    void shouldGetSize() {

        assertEquals(0, linkedList.size());
        linkedList.add(0, "b");
        linkedList.add(1, "a");
        linkedList.add(2, "r");

        assertEquals(3, linkedList.size());
    }


}
