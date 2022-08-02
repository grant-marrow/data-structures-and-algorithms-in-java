package com.faith.techinterview.queues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GQueueTest {
    @Test
    public void testEnqueue() {
        GQueue<Integer> queue = new GQueue<>();
        assertThat(queue.getLength()).isEqualTo(0);

        queue.enqueue(10);
        assertThat(queue.getLength()).isEqualTo(1);
        assertThat(queue.getFirst()).isEqualTo(queue.getLast());
        assertThat(queue.getFirst().getValue()).isEqualTo(10);

        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        assertThat(queue.getLength()).isEqualTo(5);
        assertThat(queue.getFirst()).isNotEqualTo(queue.getLast());
        assertThat(queue.getLast().getValue()).isEqualTo(50);
        assertThat(queue.getFirst().getNext().getValue()).isEqualTo(20);
    }

    @Test
    public void testDequeue() {
        GQueue<Integer> queue = new GQueue<>();
        assertThat(queue.getLength()).isEqualTo(0);

        queue.enqueue(10);
        assertThat(queue.getLength()).isEqualTo(1);
        assertThat(queue.getFirst()).isEqualTo(queue.getLast());
        assertThat(queue.getFirst().getValue()).isEqualTo(10);

        Integer dequeue = queue.dequeue();
        assertThat(dequeue).isEqualTo(10);
        assertThat(queue.getLength()).isEqualTo(0);
        assertThat(queue.getFirst()).isNull();
        assertThat(queue.getLast()).isNull();

        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        assertThat(queue.getLength()).isEqualTo(4);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(20);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);
        assertThat(queue.getLength()).isEqualTo(4);
        Integer dequeue1 = queue.dequeue();

        assertThat(dequeue1).isEqualTo(20);
        assertThat(queue.getLength()).isEqualTo(3);
        assertThat(queue.getFirst().getValue()).isEqualTo(200);
        assertThat(queue.getLast().getValue()).isEqualTo(400);
    }

    @Test
    public void testPeek() {
        GQueue<Integer> queue = new GQueue<>();
        assertThat(queue.getLength()).isEqualTo(0);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        Integer peek = queue.peek();
        assertThat(peek).isEqualTo(20);
        queue.dequeue();

        Integer peek1 = queue.peek();
        assertThat(peek1).isEqualTo(30);
    }

}
