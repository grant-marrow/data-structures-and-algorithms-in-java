package com.faith.techinterview.stacks;

import com.faith.techinterview.arrays.GArray;
import lombok.Getter;

@Getter

public class GStackWithArray {
    private GArray array = new GArray();

    public void push(int value) {
        this.array.push(value);
    }

    public int pop() {
        return this.array.pop();
    }

    public int peek() {
        return this.array.lookup(this.array.length() - 1);
    }

    public int getTop() {
        return this.peek();
    }

    public int getBottom() {
        return this.array.lookup(0);
    }

    public int getLength() {
        return this.array.length();
    }

}
