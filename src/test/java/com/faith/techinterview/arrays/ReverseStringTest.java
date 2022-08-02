package com.faith.techinterview.arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ReverseStringTest {

    @Test
    public void testReverse() {
        String original = "Hi my name is Grant";
        final ReverseString reverseString = new ReverseString();
        final String reversed = reverseString.reverse(original);
        assertThat(reversed).isEqualTo("tnarG si eman ym iH");
        assertThat(reversed.length()).isEqualTo(original.length());

        String reversed1 = reverseString.reverse("a");
        assertThat(reversed1).isEqualTo("a");
        assertThat(reversed1.length()).isEqualTo("a".length());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReverseError() {
        final ReverseString reverseString = new ReverseString();
        reverseString.reverse(null);
    }
}
