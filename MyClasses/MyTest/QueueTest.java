import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    Queue queue = new Queue(3);

    @Test
    public void testQueueEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(4);
        queue.enqueue(9);
       assertEquals(2, queue.getSize());
    }

    @Test
    public void testQueueIsFullWhileEnqueueing() {
        queue.enqueue(4);
        queue.enqueue(9);
        queue.enqueue(6);
        assertThrows(RuntimeException.class, () -> queue.enqueue(1));
    }

    @Test
    public void testDequeue() {
        queue.enqueue(4);
        queue.enqueue(9);
        assertEquals(4, queue.dequeue(4));
        assertEquals(1, queue.getSize());
    }

    @Test
    public void testDequeueWhileQueueIssEmpty() {
        assertThrows(RuntimeException.class, () -> queue.dequeue(8));
    }

    @Test
    public void testPeek() {
        queue.enqueue(4);
        queue.enqueue(9);
        queue.enqueue(8);
        assertEquals(4, queue.peek());
        assertEquals(3, queue.getSize());
    }

    @Test
    public void testPeekWhileQueueIsEmpty() {
        assertThrows(RuntimeException.class, () -> queue.peek());
    }

    @Test
    public void testQueueIsFull() {
        queue.enqueue(9);
        queue.enqueue(9);
        queue.enqueue(9);
        assertTrue(queue.isFull());
    }

    @Test
    public void testClear() {
        queue.enqueue(9);
        queue.enqueue(9);
        queue.enqueue(9);
        queue.clear();
        assertEquals(0, queue.getSize());
    }

    @Test
    public void testContains() {
        queue.enqueue(7);
        queue.enqueue(2);
        queue.enqueue(9);
        assertEquals(7, queue.contains(7));
    }

}