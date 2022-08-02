package com.faith.techinterview.hashtables;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GHashTableTest {

    @Test
    public void testSet() {
        GHashTable<Integer> table = new GHashTable<>(50);
        table.set("grapes", 1000);

        table.set("grant marrow", 2000);

        table.keys();

        assertThat(table.get("grapes")).isEqualTo(1000);
        assertThat(table.get("grant marrow")).isEqualTo(2000);
    }
}
