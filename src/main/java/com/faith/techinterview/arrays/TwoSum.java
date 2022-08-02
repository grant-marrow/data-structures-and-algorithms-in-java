package com.faith.techinterview.arrays;

import java.util.*;

class Pair implements Comparable<Pair> {
    private final int index;
    private final int value;

    public Pair(final int index, final int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return this.index;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(Pair pair) {
        if (this.value == pair.getValue()) {
            return 0;
        } else if (this.value > pair.getValue()) {
            return 1;
        } else return -1;
    }
}
public class TwoSum {
    public int[] solution(int[] nums, int target) {
        //This method has a big O complexity of O(n).

        //Validate input
        if (nums == null) {
            throw new IllegalArgumentException("Nums cannot be null");
        }
        if (nums.length == 0) {
            return nums;
        }

        //We want to apply two pointer pattern
        //but this works best with a sorted array.
        //We know the array input is not sorted
        //so we build a list of the original index
        //and its related values.
        //Which we will sort, then apply the two
        //pointer pattern to the list.
        final List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            pairs.add(new Pair(i, nums[i]));
        }

        Collections.sort(pairs);

        int[] indices = new int[2];
        int x = 0; //pointer 1 points to the start of the list
        int y = pairs.size() - 1; //pointer 2 starts at the end of the list
        int total = Integer.MIN_VALUE;

        while (x < y) {
            Pair front = pairs.get(x);
            Pair back = pairs.get(y);
            total = front.getValue() + back.getValue();
            //move backwards if the total of the current pair is greater than target
            //move forward if the total of the current pair is less than target
            if (total > target) {
                y--;
            } else if (total < target) {
                x++;
            } else {
                //we apply this condition to make sure that the
                //expected indices match the original position
                //of the values.
                if (front.getIndex() < back.getIndex()) {
                    indices[0] = front.getIndex();
                    indices[1] = back.getIndex();
                } else {
                    indices[0] = back.getIndex();
                    indices[1] = front.getIndex();
                }
                break;
            }
        }
        return indices;
    }
}
