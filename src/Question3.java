// Furkan BAYTAK 210316033

// Furkan ÖZKAYA 200316060

class MultipleStacks {
    private final int stackCapacity;
    private final int[] values;
    private final int[] sizes;

    public MultipleStacks(int numStacks, int stackCapacity) {
        this.stackCapacity = stackCapacity;
        this.values = new int[numStacks * stackCapacity];
        this.sizes = new int[numStacks];
    }

    public void push(int stackNum, int value) throws FullStackException {
        if (isFull(stackNum)) {
            throw new FullStackException();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) throws EmptyStackException {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) throws EmptyStackException {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}

class FullStackException extends Exception {
}

class EmptyStackException extends Exception {
}

public class Question3 {
    public static void main(String[] args) throws FullStackException, EmptyStackException {
        MultipleStacks myStack = new MultipleStacks(5, 3);
        myStack.push(2, 1);
        myStack.push(2, 3);
        myStack.push(1, 2);
        myStack.push(1, 3);
        myStack.push(4, 4);
        myStack.pop(2);
        System.out.println(myStack.peek(2));
    }
}
