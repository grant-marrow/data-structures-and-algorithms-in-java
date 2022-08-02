package com.faith.techinterview.stacks;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class GStackNode<T> {
    private T value;
    private GStackNode<T> next;
}


@Getter
public class GStackWithLinkedList<T> {
    private GStackNode<T> top;
    private GStackNode<T> bottom;
    private int length;


    public void push(T value) {
        GStackNode<T> node = new GStackNode<>();
        node.setValue(value);
        if (this.length == 0) {
            this.top = node;
            this.bottom = this.top;
        } else {
            GStackNode<T> temp = this.top;
            this.top = node;
            this.top.setNext(temp);
        }
        this.length++;
    }

    public T pop() {
        if (this.length == 0) {
            return null;
        } else if (this.length == 1) {
            GStackNode<T> current = this.top;
            this.top = null;
            this.bottom = null;
            this.length = 0;
            return current.getValue();
        } else {
            GStackNode<T> pop = this.top;
            GStackNode<T> newTop = pop.getNext();
            this.top = newTop;
            this.length--;
            return pop.getValue();
        }
    }

    public T peek() {
        if (this.length == 0) {
            return null;
        }

        return this.top.getValue();
    }
}
