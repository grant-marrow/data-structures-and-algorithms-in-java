package com.faith.techinterview.arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TwoSumTest {
    @Test
    public void testTwoSum() {
        TwoSum ts = new TwoSum();
        int[] solution = ts.solution(new int[]{2,7,11,15}, 9);
        assertThat(solution[0]).isEqualTo(0);
        assertThat(solution[1]).isEqualTo(1);
        int[] solution1 = ts.solution(new int[0], 10);
        assertThat(solution1.length).isEqualTo(0);

        int[] solution2 = ts.solution(new int[]{3,3}, 6);
        assertThat(solution2[0]).isEqualTo(0);
        assertThat(solution2[1]).isEqualTo(1);

        int[] solution3 = ts.solution(new int[]{0, 4, 3,0}, 0);
        assertThat(solution3[0]).isEqualTo(0);
        assertThat(solution3[1]).isEqualTo(3);

        int[] solution5 = ts.solution(new int[]{-1, -2, -3,-4,-5}, -8);
        assertThat(solution5[0]).isEqualTo(2);
        assertThat(solution5[1]).isEqualTo(4);

        int[] solution4 = ts.solution(new int[]{-10, 7, 19,15}, 9);
        assertThat(solution4[0]).isEqualTo(0);
        assertThat(solution4[1]).isEqualTo(2);

        int[] solution6 = ts.solution(new int[]{150,24,79,50,88,345,3}, 200);
        assertThat(solution6[0]).isEqualTo(0);
        assertThat(solution6[1]).isEqualTo(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTwoSumError() {
        TwoSum ts = new TwoSum();
        ts.solution(null, 9);
    }

}
