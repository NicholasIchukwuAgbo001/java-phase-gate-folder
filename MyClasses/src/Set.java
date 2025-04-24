import static java.awt.geom.Path2D.contains;

public class Set {
    int[] elements;
    int counter;
    int size;

    public Set(int size) {
        elements = new int[size];
        counter = 0;
        this.size = size;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    private void resize() {
        size *= 2;
        int[] newArray = new int[size];
        for (int count = 0; count < elements.length; count++) {
            newArray[count] = elements[count];
        }
        elements = newArray;
    }

    public int getSize() {
        return counter;
    }

    public boolean add(int element) {
        for (int count = 0; count < counter; count++) {
            if (elements[count] == element) {
                return false;
            }
        }
        if (counter == elements.length) {
            resize();
        }
        elements[counter++] = element;
        return true;
    }

    public boolean remove(int element) {
        if (counter == 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int count = 0; count < counter; count++) {
            if (elements[count] == element) {
                counter--;
                return true;
            }
        }
        return false;
    }

    public boolean contains(int element) {
        for (int count = 0; count < counter; count++) {
            if (elements[count] == element) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        counter = 0;
    }

}
