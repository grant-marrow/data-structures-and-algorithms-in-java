package com.faith.techinterview.stacks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GStackWithLinkedListTest {

    @Test
    public void testPush() {
        GStackWithLinkedList<Integer> stack = new GStackWithLinkedList<>();

        stack.push(10);
        assertThat(stack.getTop()).isEqualTo(stack.getBottom());
        assertThat(stack.getLength()).isEqualTo(1);

        stack.push(12);
        assertThat(stack.getTop().getValue()).isEqualTo(12);
        assertThat(stack.getBottom().getValue()).isEqualTo(10);
        assertThat(stack.getLength()).isEqualTo(2);
        assertThat(stack.getTop().getNext()).isEqualTo(stack.getBottom());

        stack.push(14);
        assertThat(stack.getLength()).isEqualTo(3);
        assertThat(stack.getTop().getValue()).isEqualTo(14);
        assertThat(stack.getBottom().getValue()).isEqualTo(10);
        assertThat(stack.getTop().getNext().getValue()).isEqualTo(12);
        assertThat(stack.getTop().getNext().getNext().getValue()).isEqualTo(10);
    }

    @Test
    public void testPop() {
        GStackWithLinkedList<Integer> stack = new GStackWithLinkedList<>();

        assertThat(stack.getTop()).isNull();
        assertThat(stack.getBottom()).isNull();
        assertThat(stack.getLength()).isEqualTo(0);

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
        assertThat(stack.getTop().getValue()).isEqualTo(30);
        assertThat(stack.getTop().getNext().getValue()).isEqualTo(20);
        assertThat(stack.getTop().getNext().getNext().getValue()).isEqualTo(10);
        assertThat(stack.getBottom().getValue()).isEqualTo(10);

        Integer pop1 = stack.pop();
        assertThat(pop1).isEqualTo(30);
        assertThat(stack.getLength()).isEqualTo(2);
        assertThat(stack.getTop().getValue()).isEqualTo(20);
        assertThat(stack.getTop().getNext().getValue()).isEqualTo(10);
        assertThat(stack.getBottom().getValue()).isEqualTo(10);

        stack.pop();
        stack.pop();
        assertThat(stack.getLength()).isEqualTo(0);
        assertThat(stack.getTop()).isNull();
        assertThat(stack.getBottom()).isNull();


        Integer pop2 = stack.pop();
        assertThat(stack.getLength()).isEqualTo(0);
        assertThat(pop2).isNull();
        assertThat(stack.getTop()).isNull();
        assertThat(stack.getBottom()).isNull();
    }

    @Test
    public void testPeek() {
        GStackWithLinkedList<Integer> stack = new GStackWithLinkedList<>();

        Integer peek = stack.peek();
        assertThat(peek).isNull();

        stack.push(10);
        Integer peek1 = stack.peek();
        assertThat(peek1).isEqualTo(10);
        assertThat(stack.getLength()).isEqualTo(1);
        assertThat(stack.getTop().getValue()).isEqualTo(10);


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
        assertThat(stack.getTop().getValue()).isEqualTo(20);
    }
}
