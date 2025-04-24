import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SetTest {

    Set set = new Set(3);

    @Test
    public void testSetIsEmpty() {
        assertTrue(set.isEmpty());
    }

    @Test
    public void testAdd() {
        set.add(2);
        set.add(4);
        set.add(6);
        assertEquals(3, set.getSize());
    }

    @Test
    public void testRemove() {
        set.add(2);
        set.add(4);
        set.add(6);
        assertTrue(set.remove(6));
    }

    @Test
    public void testRemove_false() {
        set.add(2);
        set.add(4);
        set.add(6);
        assertFalse(set.remove(10));
    }

    @Test
    public void testContains() {
        set.add(2);
        set.add(4);
        set.add(6);
        assertTrue(set.contains(4));
    }

    @Test
    public void testContains_false() {
        set.add(2);
        set.add(4);
        set.add(6);
        assertFalse(set.contains(1));
    }

    @Test
    public void testClear() {
        set.add(2);
        set.add(4);
        set.add(6);
        set.clear();
        assertEquals(0, set.getSize());
    }

}