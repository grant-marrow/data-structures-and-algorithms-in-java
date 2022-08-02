package com.faith.techinterview.arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MaximumSubArrayTest {
    @Test
    public void testMaxSubArray() {
        MaximumSubArray msa = new MaximumSubArray();
        int result = msa.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        //-5 -3 -2 -1 1 1 2 4 4
        assertThat(result).isEqualTo(6);

        int result1 = msa.maxSubArray(new int[]{1});
        assertThat(result1).isEqualTo(1);

        int result2 = msa.maxSubArray(new int[]{5,4,-1,7,8});
        assertThat(result2).isEqualTo(23);
    }

}
