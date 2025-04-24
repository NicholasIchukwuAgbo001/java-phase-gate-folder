public class LinkedList {
    int[] elements;
    int size;
    int counter;

    public LinkedList(int size) {
        elements = new int[size];
        counter = 0;
        this.size = size;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public int getSize() {
        return counter;
    }

    private void resize() {
        size *= 2;
        int[] newArray = new int[size];
        for (int count = 0; count < elements.length; count++) {
            newArray[count] = elements[count];
        }
        elements = newArray;
    }

    public void add(int element) {
        if (counter == elements.length) {
            resize();
        }
        elements[counter++] = element;
    }

    public int removeFirst() {
        if (counter == 0) {
            throw new IndexOutOfBoundsException();
        }
        int firstElement = elements[0];
        counter--;
        return firstElement;
    }

    public int removeLast() {
        if (counter == 0) {
            throw new IndexOutOfBoundsException();
        }
        return elements[--counter];
    }

    public void clear() {
        counter = 0;
    }

    public int get(int index) {
        if (index >= counter) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public boolean remove(int element) {
        if (counter == 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < counter; i++) {
            if (elements[i] == element) {
                counter--;
                return true;
            }
        }
        return false;
    }


}
