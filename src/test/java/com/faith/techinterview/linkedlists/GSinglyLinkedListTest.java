package com.faith.techinterview.linkedlists;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GSinglyLinkedListTest {
    @Test
    public void testReverse() {
        GSinglyLinkedList<Integer> linkedList = new GSinglyLinkedList<>(12);
        linkedList.append(13);
        linkedList.append(14);
        linkedList.append(15);
        linkedList.append(16);
        assertThat(linkedList.getLength()).isEqualTo(5);
        linkedList.printList();
        System.out.println();
        GSinglyLinkedList<Integer> reverse = linkedList.reverse2();
        reverse.printList();
        assertThat(linkedList.getLength()).isEqualTo(5);
    }
    @Test
    public void testPrepend() {
        GSinglyLinkedList<Integer> linkedList = new GSinglyLinkedList<>(12);
        linkedList.prepend(20);

        assertThat(linkedList.getHead()).isNotNull();
        assertThat(linkedList.getTail()).isNotNull();
        assertThat(linkedList.getHead().getValue()).isEqualTo(20);
        assertThat(linkedList.getHead().getNext()).isEqualTo(linkedList.getTail());
        assertThat(linkedList.getHead().getNext().getValue()).isEqualTo(linkedList.getTail().getValue());
        assertThat(linkedList.getTail().getNext()).isNull();
        assertThat(linkedList.getLength()).isEqualTo(2);

        linkedList.prepend(31);
        assertThat(linkedList.getHead().getValue()).isEqualTo(31);
        assertThat(linkedList.getHead().getNext().getValue()).isEqualTo(20);
        assertThat(linkedList.getTail().getValue()).isEqualTo(12);
        assertThat(linkedList.getTail().getNext()).isNull();
        assertThat(linkedList.getLength()).isEqualTo(3);

        linkedList.prepend(5);
        assertThat(linkedList.getHead().getValue()).isEqualTo(5);
        assertThat(linkedList.getHead().getNext().getValue()).isEqualTo(31);
        assertThat(linkedList.getTail().getValue()).isEqualTo(12);
        assertThat(linkedList.getTail().getNext()).isNull();
        assertThat(linkedList.getLength()).isEqualTo(4);
    }

    @Test
    public void testAppend() {
        GSinglyLinkedList<Integer> linkedList = new GSinglyLinkedList<>(12);

        assertThat(linkedList.getHead()).isNotNull();
        assertThat(linkedList.getTail()).isNotNull();
        assertThat(linkedList.getHead().getValue()).isEqualTo(12);
        assertThat(linkedList.getTail().getValue()).isEqualTo(12);
        assertThat(linkedList.getHead().getNext()).isNull();
        assertThat(linkedList.getTail().getNext()).isNull();
        assertThat(linkedList.getLength()).isEqualTo(1);

        linkedList.append(20);
        assertThat(linkedList.getHead().getNext()).isNotNull();
        assertThat(linkedList.getHead().getNext().getValue()).isEqualTo(20);
        assertThat(linkedList.getHead().getNext().getNext()).isNull();
        assertThat(linkedList.getTail().getValue()).isEqualTo(20);
        assertThat(linkedList.getTail().getNext()).isNull();
        assertThat(linkedList.getLength()).isEqualTo(2);

        linkedList.append(31);
        assertThat(linkedList.getHead().getValue()).isEqualTo(12);
        assertThat(linkedList.getHead().getNext().getValue()).isEqualTo(20);
        assertThat(linkedList.getHead().getNext().getNext().getValue()).isEqualTo(31);
        assertThat(linkedList.getHead().getNext().getNext().getNext()).isNull();
        assertThat(linkedList.getTail().getValue()).isEqualTo(31);
        assertThat(linkedList.getTail().getNext()).isNull();
        assertThat(linkedList.getLength()).isEqualTo(3);
    }

    @Test
    public void testInsert() {
        GSinglyLinkedList<Integer> linkedList = new GSinglyLinkedList<>(12);
        linkedList.prepend(31);
        linkedList.append(43);
        assertThat(linkedList.getLength()).isEqualTo(3);
        linkedList.printList();
        linkedList.insert(54, 1);
        System.out.println("");
        assertThat(linkedList.getLength()).isEqualTo(4);
        linkedList.printList();

        linkedList.insert(11, -1);
        System.out.println("");
        assertThat(linkedList.getLength()).isEqualTo(5);
        linkedList.printList();

        linkedList.insert(99, 20);
        System.out.println("");
        assertThat(linkedList.getLength()).isEqualTo(6);
        linkedList.printList();

        linkedList.insert(777, 4);
        System.out.println("");
        assertThat(linkedList.getLength()).isEqualTo(7);
        linkedList.printList();
    }

    @Test
    public void testDelete() {
        GSinglyLinkedList<Integer> linkedList = new GSinglyLinkedList<>(12);
        linkedList.prepend(31);
        linkedList.append(43);
        assertThat(linkedList.getLength()).isEqualTo(3);
        linkedList.printList();
        linkedList.insert(54, 1);
        System.out.println("");
        assertThat(linkedList.getLength()).isEqualTo(4);
        linkedList.printList();

        linkedList.delete(-1);
        System.out.println("");
        assertThat(linkedList.getLength()).isEqualTo(3);
        linkedList.printList();

        linkedList.delete(6);
        System.out.println("");
        assertThat(linkedList.getLength()).isEqualTo(3);
        linkedList.printList();

        linkedList.delete(1);
        System.out.println("");
        assertThat(linkedList.getLength()).isEqualTo(2);
        linkedList.printList();

        GSinglyLinkedList<Integer> delete = linkedList.delete(1);
        System.out.println("");
        assertThat(linkedList.getLength()).isEqualTo(1);
        linkedList.printList();

        assertThat(delete.getHead().getValue()).isEqualTo(delete.getTail().getValue());

    }

    @Test
    public void testLookup() {
        GSinglyLinkedList<Integer> linkedList = new GSinglyLinkedList<>(12);
        linkedList.prepend(31);
        linkedList.append(43);
        assertThat(linkedList.getLength()).isEqualTo(3);
        linkedList.printList();
        linkedList.insert(54, 1);
        System.out.println("");
        assertThat(linkedList.getLength()).isEqualTo(4);
        linkedList.append(78);
        linkedList.printList();

        GSinglyNode<Integer> lookup = linkedList.lookup(1);
        assertThat(lookup.getValue()).isEqualTo(54);

        GSinglyNode<Integer> lookup1 = linkedList.lookup(14);
        assertThat(lookup1).isNull();

        GSinglyNode<Integer> lookup2 = linkedList.lookup(4);
        assertThat(lookup2.getValue()).isEqualTo(78);
        System.out.println("");
        linkedList.insert(109, 26);
        GSinglyNode<Integer> lookup3 = linkedList.lookup(5);
        assertThat(lookup3.getValue()).isEqualTo(109);
        assertThat(linkedList.getTail().getValue()).isEqualTo(109);
        linkedList.printList();

    }

}
