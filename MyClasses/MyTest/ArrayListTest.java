import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    ArrayList arrayList = new ArrayList(2);

    @Test
    public void testIsEmpty() {
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testAdd() {
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(8);
        assertEquals(6, arrayList.getSize());
    }

    @Test
    public void testSize() {
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(8);
        assertEquals(9, arrayList.getSize());
    }

    @Test
    public void testGet() {
        arrayList.add(8);
        arrayList.add(2);
        arrayList.add(4);
        assertEquals(2, arrayList.get(1));
    }

    @Test
    public void testGet_IndexOutOfBounds() {
        arrayList.add(8);
        arrayList.add(2);
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(5));
    }

    @Test
    public void testSet() {
        arrayList.add(8);
        arrayList.add(2);
        arrayList.add(9);
        arrayList.add(4);
        assertEquals(9, arrayList.set(2, 7));
    }

    @Test
    public void testSet_indexOutOfBounds() {
        arrayList.add(8);
        arrayList.add(2);
        arrayList.add(9);
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(5, 7));
    }

    @Test
    public void testClear() {
        arrayList.add(8);
        arrayList.add(2);
        arrayList.add(9);
        arrayList.add(4);
        arrayList.clear();
        assertEquals(0, arrayList.getSize());
    }

    @Test
    public void testContain() {
        arrayList.add(8);
        arrayList.add(2);
        arrayList.add(9);
        arrayList.add(4);
        assertTrue( arrayList.contain(2));
    }

    @Test
    public void testSort() {
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.sort();
        assertEquals(1, arrayList.get(0));
        assertEquals(2, arrayList.get(1));
        assertEquals(3, arrayList.get(2));
        assertEquals(4, arrayList.get(3));
        assertEquals(5, arrayList.get(4));
    }




}