package com.faith.techinterview.linkedlists;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GDoublyLinkedListTest {

    @Test
    public void testConstruction() {
        GDoublyLinkedList<Integer> linkedList = new GDoublyLinkedList<>(12);
        assertThat(linkedList.getLength()).isEqualTo(1);
        assertThat(linkedList.getHead()).isNotNull();
        assertThat(linkedList.getTail()).isNotNull();
        assertThat(linkedList.getHead().getPrevious()).isNull();

    }

    @Test
    public void testPrepend() {
        GDoublyLinkedList<Integer> linkedList = new GDoublyLinkedList<>(12);
        assertThat(linkedList.getLength()).isEqualTo(1);
        assertThat(linkedList.getHead()).isEqualTo(linkedList.getTail());

        linkedList.prepend(23);
        assertThat(linkedList.getLength()).isEqualTo(2);
        assertThat(linkedList.getHead()).isNotEqualTo(linkedList.getTail());
        assertThat(linkedList.getHead().getNext()).isEqualTo(linkedList.getTail());
        assertThat(linkedList.getTail().getPrevious()).isEqualTo(linkedList.getHead());
    }

    @Test
    public void testAppend() {
        GDoublyLinkedList<Integer> linkedList = new GDoublyLinkedList<>(12);
        assertThat(linkedList.getLength()).isEqualTo(1);
        assertThat(linkedList.getHead()).isEqualTo(linkedList.getTail());

        linkedList.append(33);
        assertThat(linkedList.getLength()).isEqualTo(2);
        assertThat(linkedList.getTail().getValue()).isEqualTo(33);
        assertThat(linkedList.getTail().getPrevious()).isEqualTo(linkedList.getHead());
    }

    @Test
    public void testInsert() {
        GDoublyLinkedList<Integer> linkedList = new GDoublyLinkedList<>(12);
        assertThat(linkedList.getLength()).isEqualTo(1);
        assertThat(linkedList.getHead()).isEqualTo(linkedList.getTail());

        linkedList.insert(44, 3);
        assertThat(linkedList.getLength()).isEqualTo(2);
        assertThat(linkedList.getHead()).isNotEqualTo(linkedList.getTail());
        assertThat(linkedList.getTail().getValue()).isEqualTo(44);
        assertThat(linkedList.getTail().getPrevious()).isEqualTo(linkedList.getHead());

        linkedList.insert(888, 1);
        assertThat(linkedList.getLength()).isEqualTo(3);
        assertThat(linkedList.getHead()).isNotEqualTo(linkedList.getTail());
        assertThat(linkedList.getTail().getValue()).isEqualTo(44);
        assertThat(linkedList.getTail().getPrevious().getValue()).isEqualTo(888);
        assertThat(linkedList.getHead().getValue()).isEqualTo(12);
    }

    @Test
    public void testDelete() {
        GDoublyLinkedList<Integer> linkedList = new GDoublyLinkedList<>(12);
        assertThat(linkedList.getLength()).isEqualTo(1);
        assertThat(linkedList.getHead()).isEqualTo(linkedList.getTail());

        linkedList.delete(0);
        assertThat(linkedList.getLength()).isEqualTo(0);
        assertThat(linkedList.getHead()).isNull();
        assertThat(linkedList.getTail()).isNull();

        linkedList.delete(-1);
        assertThat(linkedList.getLength()).isEqualTo(0);
        assertThat(linkedList.getHead()).isNull();
        assertThat(linkedList.getTail()).isNull();

        linkedList.append(12);
        linkedList.append(13);
        linkedList.append(14);
        linkedList.append(15);
        assertThat(linkedList.getLength()).isEqualTo(4);

        linkedList.delete(2);
        assertThat(linkedList.getLength()).isEqualTo(3);
        assertThat(linkedList.getHead().getValue()).isEqualTo(12);
        assertThat(linkedList.getHead().getNext().getValue()).isEqualTo(13);
        assertThat(linkedList.getHead().getPrevious()).isNull();
        assertThat(linkedList.getTail().getValue()).isEqualTo(15);
        assertThat(linkedList.getTail().getPrevious()).isEqualTo(linkedList.getHead().getNext());


    }

}
