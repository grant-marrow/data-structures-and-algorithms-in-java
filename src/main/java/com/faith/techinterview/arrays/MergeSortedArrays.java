package com.faith.techinterview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSortedArrays {
    public List<Integer> merge(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        final List<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            list.add(i);
        }

        for (int i : arr2) {
            list.add(i);
        }
        Collections.sort(list);
        return list;
    }
}
