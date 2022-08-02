package com.faith.techinterview.queues;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class GQueueNode<T> {
    private T value;
    private GQueueNode<T> next;

    public GQueueNode(T value) {
        this.value = value;
    }
}

@Getter
public class GQueue<T> {
    private GQueueNode<T> first;
    private GQueueNode<T> last;
    private int length;

    public GQueue() {
        this.length = 0;
    }

    public T peek() {
        if (this.length == 0) {
            return null;
        }

        return this.first.getValue();
    }

    public void enqueue(T value) {
        GQueueNode<T> node = new GQueueNode<>(value);
        if (this.length == 0) {
            this.first = node;
            this.last = this.first;
        } else {

            /**
             * first = 1
             * last = 1
             *
             * first = 1, first.next = 2
             * last = 2
             *
             * first = 1, first.next= 2, first.next.next = 3
             * last = 3
             *
             *
             */

            GQueueNode<T> temp = this.last;
            this.last = node;
            temp.setNext(this.last);
        }
        this.length++;
    }

    public T dequeue() {
        if (this.length == 0) {
            return null;
        } else if (this.length == 1) {
            GQueueNode<T> current = this.first;
            this.last = null;
            this.first = null;
            this.length = 0;
            return current.getValue();
        } else {
            GQueueNode<T> temp = this.first;
            GQueueNode<T> newFirst = temp.getNext();
            this.first = newFirst;
            this.length--;
            return temp.getValue();
        }
    }

    public boolean isEmpty() {
        return this.length == 0;
    }
}
