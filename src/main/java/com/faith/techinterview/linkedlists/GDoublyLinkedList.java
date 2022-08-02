package com.faith.techinterview.linkedlists;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class GDoublyNode<T> {
    private T value;
    private GDoublyNode<T> next;
    private GDoublyNode<T> previous;
}

@Getter
public class GDoublyLinkedList<T> {
    private GDoublyNode<T> head;
    private GDoublyNode<T> tail;
    private int length;

    public GDoublyLinkedList(T value) {
        this.construct(value);
    }

    public GDoublyNode<T> lookup(int idx) {
        if (idx > this.length || idx < 0) {
            return null;
        }

        GDoublyNode<T> current = this.head;
        int i = 0;
        while(i != idx) {
            current = current.getNext();
            i++;
        }
        return current;
    }

    public GDoublyLinkedList prepend(T value) {
        if (this.head == null && this.tail == null) {
            this.construct(value);
        } else {
            GDoublyNode<T> temp = this.head;
            this.head = new GDoublyNode<>();
            this.head.setValue(value);
            this.head.setNext(temp);
            temp.setPrevious(this.head);

            this.length++;
        }
        return this;
    }

    private void construct(T value) {
        this.head = new GDoublyNode<>();
        this.head.setValue(value);
        this.tail = this.head;
        this.length++;
    }
    public GDoublyLinkedList append(T value) {
        //When we append, we follow the same approach as we do with prepend,
        // except we focus on the tail, instead of the head.
        if (this.head == null && this.tail == null) {
            this.construct(value);
        } else {
            GDoublyNode<T> temp = this.tail;
            this.tail = new GDoublyNode<>();
            this.tail.setValue(value);
            temp.setNext(this.tail);

            this.tail.setPrevious(temp);

            this.length++;
        }
        return this;
    }

    public GDoublyLinkedList<T> insert(T value, int idx) {
        if (idx >= this.length) {
            this.append(value);
        } else if (idx <= 0) {
            this.prepend(value);
        } else {
            GDoublyNode<T> next = lookup(idx);

            final GDoublyNode<T> node = new GDoublyNode<>();
            node.setNext(next);
            node.setValue(value);

            GDoublyNode<T> previous = next.getPrevious();
            if (previous != null) {
                node.setPrevious(previous);
                previous.setNext(node);
            }

            next.setPrevious(node);

            this.length++;
        }
        return this;
    }

    public GDoublyLinkedList<T> delete(int idx) {
        if (this.length == 0) {
            return this;
        }

        if (idx <= 0) {
            //when we try to delete the head
            GDoublyNode<T> next = this.head.getNext();
            this.head = next;

            if (this.head == null) {
                this.tail = null;
            }

            this.length--;
        } else if (idx > this.length) {
            //when the index is greater than the size of the linked list
            return this;
        } else {
            //when we delete specific indexes and the tail.
            GDoublyNode<T> current = this.lookup(idx);

            GDoublyNode<T> previous = current.getPrevious();
            GDoublyNode<T> next = current.getNext();

            previous.setNext(next);
            if (next != null)  {
                next.setPrevious(previous);
            }

            this.length--;
        }

        return this;
    }

}
