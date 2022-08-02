package com.faith.techinterview.stacks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GStackWithArrayTest {
    @Test
    public void testPush() {
        GStackWithArray stack = new GStackWithArray();

        stack.push(10);
        assertThat(stack.getTop()).isEqualTo(stack.getBottom());
        assertThat(stack.getLength()).isEqualTo(1);

        stack.push(12);
        assertThat(stack.getTop()).isEqualTo(12);
        assertThat(stack.getBottom()).isEqualTo(10);
        assertThat(stack.getLength()).isEqualTo(2);
        assertThat(stack.getTop()).isNotEqualTo(stack.getBottom());

        stack.push(14);
        assertThat(stack.getLength()).isEqualTo(3);
        assertThat(stack.getTop()).isEqualTo(14);
        assertThat(stack.getBottom()).isEqualTo(10);
    }

    @Test(expected = NoSuchElementException.class)
    public void testPop() {
        GStackWithArray stack = new GStackWithArray();
        assertThat(stack.getLength()).isEqualTo(0);
        assertThat(stack.getTop()).isNull();
        assertThat(stack.getBottom()).isNull();

        stack.push(10);
        assertThat(stack.getTop()).isEqualTo(stack.getBottom());
        assertThat(stack.getLength()).isEqualTo(1);

        Integer pop = stack.pop();
        assertThat(stack.getLength()).isEqualTo(0);
        assertThat(pop).isEqualTo(10);
        assertThat(stack.getTop()).isNull();
        assertThat(stack.getBottom()).isNull();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertThat(stack.getLength()).isEqualTo(3);
        assertThat(stack.getTop()).isEqualTo(30);
        assertThat(stack.getBottom()).isEqualTo(10);

        Integer pop1 = stack.pop();
        assertThat(pop1).isEqualTo(30);
        assertThat(stack.getLength()).isEqualTo(2);
        assertThat(stack.getTop()).isEqualTo(20);
        assertThat(stack.getBottom()).isEqualTo(10);

        stack.pop();
        stack.pop();

        assertThat(stack.getLength()).isEqualTo(0);
        assertThat(stack.getTop()).isNull();
        assertThat(stack.getBottom()).isNull();

        stack.pop();
        assertThat(stack.getLength()).isEqualTo(0);
        assertThat(stack.getTop()).isNull();
        assertThat(stack.getBottom()).isNull();
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeek() {
        GStackWithArray stack = new GStackWithArray();
        stack.peek();

        stack.push(10);
        Integer peek1 = stack.peek();
        assertThat(peek1).isEqualTo(10);
        assertThat(stack.getLength()).isEqualTo(1);
        assertThat(stack.getTop()).isEqualTo(10);
        assertThat(stack.getBottom()).isEqualTo(10);

        stack.pop();
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.pop();
        stack.pop();
        stack.push(60);
        stack.push(70);
        stack.pop();
        stack.pop();
        stack.pop();

        Integer peek2 = stack.peek();
        assertThat(peek2).isEqualTo(20);
        assertThat(stack.getLength()).isEqualTo(1);
        assertThat(stack.getTop()).isEqualTo(20);
        assertThat(stack.getBottom()).isEqualTo(20);

    }

}
