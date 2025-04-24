import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    LinkedList linkedList = new LinkedList(2);

    @Test
    public void testIsEmpty() {
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testAdd() {
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(2);
        assertEquals(3, linkedList.getSize());
    }

    @Test
    public void testRemove() {
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(9);
        assertTrue(linkedList.remove(9));
        assertEquals(2, linkedList.getSize());
    }

    @Test
    public void testRemoveFromEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(2));
    }

    @Test
    public void testRemoveFirst() {
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(9);
        assertEquals(2, linkedList.removeFirst());
    }

    @Test
    public void testRemoveFirstFromEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.removeFirst());
    }

    @Test
    public void testRemoveLast() {
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(9);
        assertEquals(9, linkedList.removeLast());
    }

    @Test
    public void testRemoveLastFromEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.removeLast());
    }

    @Test
    public void testClear() {
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(9);
        linkedList.clear();
        assertEquals(0, linkedList.getSize());
    }

    @Test
    public void testGet() {
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(9);
        assertEquals(4, linkedList.get(1));
    }

    @Test
    public void testGet_indexOutOfBounds() {
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(9);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(5));
    }

}