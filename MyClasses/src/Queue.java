public class Queue {
    int[] elements;
    int counter;
    int front = 0;

    public Queue(int size) {
        elements = new int[size];
        counter = 0;
    }

    public int enqueue(int element) {
        if (counter == elements.length) {
            throw new RuntimeException("Queue is full");
        }
        elements[counter++] = element;
        return element;
    }

    public int getSize() {
        return counter;
    }

    public int dequeue(int element) {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        elements[counter--] = element;
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
       return elements[front];
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == elements.length;
    }

}
