import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class StackTest {

    Stack stack = new Stack(5);

    @Test
    public void is_empty() {
        assertTrue(stack.is_empty());
    }


    @Test
    public void testPush() {
        stack.push(9);
        stack.push(6);
        stack.push(3);
        assertEquals(3, stack.getSize());
    }

    @Test
    public void testStackIsFullWhilePushing() {
        stack.push(9);
        stack.push(6);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertThrows(StackOverflowError.class, () -> stack.push(4));
    }

    @Test
    public void testPop() {
        stack.push(9);
        stack.push(6);
        assertEquals(6, stack.pop());
    }
    @Test
    public void testStackIsEmptyWhilePopping() {
        assertThrows(StackOverflowError.class, () -> stack.pop());
    }

    @Test
    public void testPeek() {
        stack.push(9);
        stack.push(6);
        stack.push(3);
        assertEquals(3, stack.peek());
    }

    @Test
    public void testStackIsEmptyWhilePeeking() {
        assertThrows(StackOverflowError.class, () -> stack.peek());
    }

    @Test
    public void testSize() {
        stack.push(9);
        stack.push(6);
        assertEquals(2, stack.getSize());
    }

    @Test
    public void testSizeIsZero() {
        assertEquals(0, stack.getSize());
    }

    @Test
    public void testSearch() {
        stack.push(9);
        stack.push(6);
        stack.push(3);
        stack.push(4);
        assertTrue(stack.search(6));
    }

    @Test
    public void testSearchIsFalse() {
        stack.push(9);
        stack.push(6);
        stack.push(3);
        stack.push(4);
        assertFalse(stack.search(2));
    }

    @Test
    public void testSearchFromEmptyStack() {
        assertThrows(StackOverflowError.class, () -> stack.search(7));
    }


}