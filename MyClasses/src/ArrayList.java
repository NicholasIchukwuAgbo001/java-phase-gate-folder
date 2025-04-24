public class ArrayList {
    int[]  elements;
    int counter;
    int  size;

    public ArrayList(int size) {
        this.size = size;
        elements = new int[size];
        counter = 0;
    }

    public boolean isEmpty() {
        return counter == 0;
    }


    public void add(int value) {
        if (counter == elements.length) {
            resize();
        }
        elements[counter] = value;
        counter++;
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


    public int get(int index) {
        if (index < 0 || index >= counter) {
           throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }


    public int set(int index, int element) {
        if (index < 0 || index >= counter) {
            throw new IndexOutOfBoundsException();
        }
        int oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    public void clear() {
        counter = 0;
    }

    public boolean contain(int element) {
        for (int count = 0; count < counter; count++) {
            if (elements[count] == element) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        for (int count = 0; count < counter; count++) {
            for (int index = 0; index < counter -count -1; index++) {
                if (elements[index] > elements[index + 1]) {
                    int temp = elements[index];
                    elements[index] = elements[index + 1];
                    elements[index + 1] = temp;
                }
            }

        }
    }



}
