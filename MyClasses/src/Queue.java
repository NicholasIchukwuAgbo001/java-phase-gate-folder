public class Queue {

    int[] elements;
    int counter;
    int front = 0;
    int back = 0;

    public Queue(int size) {
        elements = new int[size];
        counter = 0;
    }

    public void enqueue(int element) {
        if (counter == elements.length) {
            throw new IndexOutOfBoundsException("Queue is full");
        }
        back++;
        elements[counter++] = element;
    }

    public int getSize() {
        return counter;
    }

    public int dequeue(int element) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        front++;
        elements[counter--] = element;
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
       return elements[front];
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == elements.length;
    }

    public void clear() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        counter = 0;
    }

    public int contains(int element) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        for (int Count = 0; Count < counter; Count++) {
            if (elements[Count] == element) {
                return elements[Count];
            }
        }
        return -1;
    }



}
