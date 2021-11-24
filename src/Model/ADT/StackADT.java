package Model.ADT;

import java.util.Stack;

public class StackADT<T> implements IStack<T> {
    Stack<T> stack;

    public StackADT(){this.stack = new Stack<>();}


    @Override
    public T pop() {
        return stack.pop();

        //TODO: exeptie stiva goala
    }

    @Override
    public void push(T element) {
        this.stack.push(element);
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public String toString(){
        return this.stack.toString();
    }
}
