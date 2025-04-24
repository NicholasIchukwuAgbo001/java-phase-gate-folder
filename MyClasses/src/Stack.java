public class Stack {
        int[] elements;
        int counter;

        public Stack(int size) {
            elements = new int[size];
            counter = 0;
        }

        public boolean is_empty() {
            return counter == 0;
        }


        public int push(int element) {
            if (counter == elements.length) {
                throw new StackOverflowError();
            }
            elements[counter++] = element;
            return element;
        }

        public int pop() {
                if (counter == 0) {
                    throw new StackOverflowError();
                }
                return elements[--counter];
        }

        public int peek() {
                if (counter == 0) {
                    throw new StackOverflowError();
                }
                return elements[counter - 1];
        }

        public int getSize() {
            return counter;
        }

        public boolean search(int element) {
            if (counter == 0) {
                throw new StackOverflowError();
            }
            for(int count = 0; count < counter; count++) {
                if (elements[count] == element) {
                    return true;
                }
            }
            return false;
        }
}
