package main.test;

import main.DIYArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
public class DIYArrayListTest {

    private DIYArrayList<String> arrayList;

    @BeforeEach
    void setUp() {
        arrayList = new DIYArrayList<>();
    }

    @Test
    void shouldAddedElements() {
        addElements("a", "b");
        assertEquals(2, arrayList.size());
    }

    @Test
    void shouldAddedElementsByIndex() {
        arrayList.add(0, "b");
        arrayList.add(1, "a");
        arrayList.add(2, "r");

        assertEquals("b", arrayList.get(0));
        assertEquals("r", arrayList.get(2));
    }

    @Test
    void shouldGetElementByIndex() {
        addElements("b", "a", "r");
        assertEquals("b", arrayList.get(0));
        assertEquals("r", arrayList.get(2));
    }

    @Test
    void shouldSortByNaturalOrder() {
        addElements("b", "a", "r");

        assertEquals("b", arrayList.get(0));
        assertEquals("a", arrayList.get(1));
        assertEquals("r", arrayList.get(2));


        arrayList.sort();

        assertEquals("a", arrayList.get(0));
        assertEquals("b", arrayList.get(1));
        assertEquals("r", arrayList.get(2));

    }

    @Test
    void shouldSortWithComparatorByLength() {
        addElements("foobar", "f", "bar");
        Comparator<String> lengthComparator = Comparator.comparing(String::length);
        arrayList.sort(lengthComparator);

        assertEquals("f", arrayList.get(0));
        assertEquals("bar", arrayList.get(1));
        assertEquals("foobar", arrayList.get(2));

    }



    @Test
    void shouldRemoveElement() {
        addElements("a", "b", "c", "d");

        String removedElement = arrayList.remove(2);

        assertEquals(3, arrayList.size());
        assertEquals("c", removedElement);
    }

    @Test
    void shouldClearsArray() {
        addElements("a", "b", "c", "d");
        arrayList.clear();

        assertEquals(0, arrayList.size());
    }

    private void addElements(String... elements) {
        for (String element : elements) {
            arrayList.add(element);
        }
    }
    //pull requestttt
}
