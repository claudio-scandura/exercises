package exercises.queues;

import java.util.Stack;

/**
 * Created by cls on 21/03/15.
 */
public class StacksQueue {

    private int size;

    private Stack<Integer> leftStack, rightStack;

    public StacksQueue() {
        leftStack = new Stack<>();
        rightStack = new Stack<>();
    }

    public int size() {
        return size;
    }

    public void enqueue(Integer i) {
        leftStack.push(i);
        size++;
    }

    public Integer dequeue() {
        if (leftStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        while (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
        Integer result = rightStack.pop();
        size--;
        while (!rightStack.isEmpty()) leftStack.push(rightStack.pop());
        return result;
    }
}
