package com.faith.techinterview.queues;

import com.faith.techinterview.stacks.GStackWithArray;

public class GQueueWithStack {
    private GStackWithArray one;
    private GStackWithArray two;

    public GQueueWithStack() {
        this.one = new GStackWithArray();
        this.two = new GStackWithArray();
    }

    public int peek() {
        fillTwoWithOne();
        return this.two.peek();
    }

    public void enqueue(int value) {
        this.one.push(value);
    }

    private void fillTwoWithOne() {
        if (this.one.getLength() != 0) {
            while(this.one.getLength() != 0) {
                this.two.push(this.one.pop());
            }
        }
    }

    public int dequeue() {
        fillTwoWithOne();
        return this.two.pop();
    }

    public int getLength() {
        fillTwoWithOne();
        return this.two.getLength();
    }

    public int getFirst() {
        fillTwoWithOne();
        return this.two.getTop();
    }

    public int getLast() {
        fillTwoWithOne();
        return this.two.getBottom();
    }
}
