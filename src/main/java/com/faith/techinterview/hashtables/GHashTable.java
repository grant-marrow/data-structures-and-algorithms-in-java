package com.faith.techinterview.hashtables;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@AllArgsConstructor
@Getter
class Entry<V> {
    private String key;
    private V value;
}
@AllArgsConstructor
@Getter
class GEntry<V> {
    private List<Entry<V>> entries;
}

public class GHashTable<V> {

    private GEntry[] table;
    public GHashTable(int size) {
        this.table = new GEntry[size];
    }

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            final int charCode = key.charAt(i);
            hash = (hash + charCode * i) % table.length;
        }
        return hash;
    }

    public void set(String key, V data) {

        int address = hash(key);
        if (this.table[address] == null) {
            GEntry<V> entry = new GEntry<>(new ArrayList<>());
            this.table[address] = entry;
        }

        this.table[address].getEntries().add(new Entry(key, data));
    }

    public V get(String key) {
        final int address = hash(key);
        List<Entry<V>> entries = this.table[address].getEntries();
        for (Entry<V> e : entries) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }

    public void keys() {
        final List<Entry<V>> entries = new ArrayList<>();
        for (GEntry gentry : this.table) {
            if (gentry != null && gentry.getEntries() != null) {
                entries.addAll(gentry.getEntries());
            }
        }

        for (Entry<V> e : entries) {
            System.out.println(e.getKey());
        }
    }

}
