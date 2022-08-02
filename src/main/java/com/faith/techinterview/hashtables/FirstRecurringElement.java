package com.faith.techinterview.hashtables;

import java.util.HashMap;
import java.util.Map;

public class FirstRecurringElement {

    public Integer findFirstRecurringElement(int[] data) {
        final Map<Integer, Integer> map = new HashMap<>();

        for (int i= 0; i < data.length; i++) {
            if (map.containsKey(data[i])) {
                return data[i];
            }
            map.put(data[i], i);
        }

        return null;
    }
}
