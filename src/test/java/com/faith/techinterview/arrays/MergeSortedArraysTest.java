package com.faith.techinterview.arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MergeSortedArraysTest {

    @Test
    public void testMergeSorted() {
        final MergeSortedArrays msa = new MergeSortedArrays();
        final int[] arr2 = new int[]{2,4,7,30};
        final int[] arr1 = new int[]{1,2,3,6,35};
        final List<Integer> merged = msa.merge(arr1, arr2);

        assertThat(merged.size()).isEqualTo(arr2.length + arr1.length);
        assertThat(merged.get(0)).isEqualTo(1);
        assertThat(merged.get(1)).isEqualTo(2);
        assertThat(merged.get(2)).isEqualTo(2);
        assertThat(merged.get(3)).isEqualTo(3);
        assertThat(merged.get(4)).isEqualTo(4);
        assertThat(merged.get(5)).isEqualTo(6);
        assertThat(merged.get(6)).isEqualTo(7);
        assertThat(merged.get(7)).isEqualTo(30);
        assertThat(merged.get(8)).isEqualTo(35);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMergeSortedError1() {
        final MergeSortedArrays msa = new MergeSortedArrays();
        msa.merge(null, new int[]{1,2});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMergeSortedError2() {
        final MergeSortedArrays msa = new MergeSortedArrays();
        msa.merge(new int[]{1,2}, null);
    }


}
