package com.faith.techinterview.queues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GQueueWithStackTest {

    @Test
    public void testEnqueue() {
        GQueueWithStack queueWithStack = new GQueueWithStack();
        assertThat(queueWithStack.getLength()).isEqualTo(0);

        queueWithStack.enqueue(10);
        assertThat(queueWithStack.getLength()).isEqualTo(1);

        assertThat(queueWithStack.peek()).isEqualTo(10);
    }

    @Test
    public void testPeek() {
        GQueueWithStack queueWithStack = new GQueueWithStack();
        assertThat(queueWithStack.getLength()).isEqualTo(0);

        queueWithStack.enqueue(10);
        assertThat(queueWithStack.getLength()).isEqualTo(1);

        assertThat(queueWithStack.peek()).isEqualTo(10);

        queueWithStack.enqueue(20);
        queueWithStack.enqueue(30);
        queueWithStack.enqueue(40);

        assertThat(queueWithStack.getLength()).isEqualTo(4);
        assertThat(queueWithStack.peek()).isEqualTo(10);
    }

}
