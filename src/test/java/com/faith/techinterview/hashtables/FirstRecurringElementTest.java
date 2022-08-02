package com.faith.techinterview.hashtables;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class FirstRecurringElementTest {

    @Test
    public void testSolution() {
        FirstRecurringElement test = new FirstRecurringElement();
        Integer firstRecurringElement = test.findFirstRecurringElement(new int[]{2, 1, 3, 4, 2, 5, 7, 8});
        assertThat(firstRecurringElement).isEqualTo(2);

        Integer firstRecurringElement1 = test.findFirstRecurringElement(new int[]{2, 1, 3, 4, 9, 5, 7, 8});
        assertThat(firstRecurringElement1).isEqualTo(null);
    }

}
