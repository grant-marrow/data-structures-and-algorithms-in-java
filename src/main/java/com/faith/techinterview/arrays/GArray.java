package com.faith.techinterview.arrays;

import java.util.NoSuchElementException;

public class GArray {
    private int[] gArray;
    private int index = 0;
    public GArray() {
        this.gArray = new int[2];
    }

    public int length() {
        return this.index;
    }

    public int size() {
        return gArray.length;
    }
    public void push(int val) {

        /*
        2 / 2 = 1 <= 0
        2 / 2 = 1 <= 1 *
        4 / 2 = 2 <= 2 *
        8 / 2 = 4 <= 3
        8 / 2 = 4 <= 4 *
        16 / 2 = 8 <= 5
        16 / 2 = 8 <= 6
        16 / 2 = 8 <= 7
        16 / 2 = 8 <= 8 *
        32 / 2 = 16 <= 9
         */

        if (this.gArray.length / 2 <= (this.index)) {
            // grow array when length divided by 2 is less or equals
            // actual size (index + 1)
            //this if condition is the reason why this method
            //becomes O(n) - because every time the array grows
            //we need to loop through the array to copy the items
            //to the new array
            //space complexity = O(n) because we create a new array where
            //we copy the original array to.
            int[] copy = new int[this.gArray.length * 2];
            System.arraycopy(gArray, 0, copy, 0, gArray.length);
            gArray = copy;
        }

        this.gArray[index] = val;
        this.index++;
    }


    public int lookup(int idx) {
        //Always O(n) because we are not iterating through items to find the
        //value
        if (idx < 0 || idx > (this.index - 1)) {
            throw new NoSuchElementException();
        }

        return this.gArray[idx];
    }

    public int pop() {
        //time complexity = O(1) because we always pop the last item
        if (index == 0) {
            throw new NoSuchElementException();
        }
        int val = this.gArray[this.index - 1];
        this.index--;
        return val;
    }

    public void delete(int idx) {
        //time complexity = O(n) because we need to loop through all
        //entries to find value
        //space complexity = O(n) because we need to create a new
        //array to copy remaining elements to after the delete.

        if (idx >= this.length()) {
            throw new NoSuchElementException();
        }

        for(int i = idx; i < gArray.length; i++) {
            int next = i + 1;
            if (next < gArray.length) {
                this.gArray[i] = this. gArray[i + 1];
            }
        }
        this.index--;
    }

    public void insert(int idx, int value) {
        if (idx >= this.index) {
            this.push(value);
        } else {
            int[] copy = new int[gArray.length + 1];
            int x = 0;
            for (int i : gArray) {
                if (x == idx) {
                    copy[x] = value;
                    x++;
                }
                copy[x] = i;
                x++;
            }
            this.gArray = copy;
            this.index++;
        }
    }
}
