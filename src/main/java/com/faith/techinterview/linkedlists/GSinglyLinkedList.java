package com.faith.techinterview.linkedlists;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
class GSinglyNode<T> {
    private T value;
    private GSinglyNode<T> next;
}

@Getter
public class GSinglyLinkedList<T> {
    private GSinglyNode<T> head;
    private GSinglyNode<T> tail;
    private int length;

    public GSinglyLinkedList(T value) {
        //When we construct a Linked List, we only have 1 value therefore
        //head.next will always be null and tail will always equal the head.
        this.head = new GSinglyNode<>();
        this.head.setValue(value);
        this.tail = this.head;
        this.length++;
    }

    public GSinglyLinkedList prepend(T value) {
        //When we prepend, we just need to get a reference to the original head
        //Set the original head reference to a new Node that matches the value being prepended
        //Then simply set the "new" head.next to the temporary reference of the original head node
        GSinglyNode<T> temp = this.head;
        this.head = new GSinglyNode<>();
        this.head.setValue(value);
        this.head.setNext(temp);
        this.length++;
        return this;
    }

    public GSinglyLinkedList append(T value) {
        //When we append, we follow the same approach as we do with prepend,
        // except we focus on the tail, instead of the head.

        GSinglyNode<T> temp = this.tail;
        this.tail = new GSinglyNode<>();
        this.tail.setValue(value);
        temp.setNext(this.tail);

        this.length++;
        return this;
    }

    public void printList() {
        GSinglyNode<T> temp = this.head;
        while(temp != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.getNext();
        }
    }

    public GSinglyLinkedList<T> insert(T value, int idx) {
        if (idx >= this.length) {
            this.append(value);
        } else if (idx <= 0) {
            this.prepend(value);
        } else {
            GSinglyNode<T> previous = lookup(idx - 1);
            GSinglyNode<T> next = previous.getNext();
            final GSinglyNode<T> node = new GSinglyNode<>();
            node.setValue(value);
            node.setNext(next);
            previous.setNext(node);
            this.length++;
        }
        return this;
    }

    public GSinglyLinkedList<T> delete(int idx) {
        if (idx <= 0) {
            //when we try to delete the head
            GSinglyNode<T> next = this.head.getNext();
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
            GSinglyNode<T> pointerBeforeDeletedItem = this.lookup(idx - 1);
            GSinglyNode<T> pointerAfterDeletedItem = pointerBeforeDeletedItem.getNext().getNext();
            pointerBeforeDeletedItem.setNext(pointerAfterDeletedItem);
            if (pointerAfterDeletedItem == null) {
                //we just deleted the tail, so we make the tail equal to the head;
                this.tail = pointerBeforeDeletedItem;
            }
            this.length--;
        }

        return this;
    }


    public GSinglyNode<T> lookup(int idx) {
        if (idx > this.length || idx < 0) {
            return null;
        }

        GSinglyNode<T> current = this.head;
        int i = 0;
        while(i != idx) {
            current = current.getNext();
            i++;
        }
        return current;
    }

    public GSinglyLinkedList<T> reverse() {
        if (this.length == 1) {
            return this;
        }

        GSinglyNode<T> current = this.head;
        final List<T> data = new ArrayList<>();
        while(current != null) {
            data.add(current.getValue());
            current = current.getNext();
        }
        GSinglyLinkedList<T> linkedList = null;
        for (int i = data.size() -1; i >= 0; i--) {
            if (linkedList == null) {
                linkedList = new GSinglyLinkedList<>(data.get(i));
            } else {
                linkedList.append(data.get(i));
            }
        }
        return linkedList;
    }

    public GSinglyLinkedList<T> reverse2() {
        if (this.length == 1) {
            return this;
        }

        GSinglyNode<T> first = this.head;
        this.tail = this.head;
        GSinglyNode<T> second = first.getNext();

        while(second != null) {
            GSinglyNode<T> temp = second.getNext();
            second.setNext(first);
            first = second;
            second = temp;
        }

        this.head.setNext(null);
        this.head = first;
        return this;
    }
}
