package com.faith.techinterview.arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GArrayTest {

    @Test
    public void testLookup() {
        GArray gArray = new GArray();
        gArray.push(23);
        gArray.push(34);
        gArray.push(55);
        gArray.push(66);

        assertThat(gArray.lookup(2)).isEqualTo(55);
        assertThat(gArray.lookup(0)).isEqualTo(23);
        assertThat(gArray.lookup(3)).isEqualTo(66);
    }

    @Test(expected = NoSuchElementException.class)
    public void testLookupError1() {
        GArray gArray = new GArray();
        gArray.lookup(2);
    }

    @Test(expected = NoSuchElementException.class)
    public void testLookupError2() {
        GArray gArray = new GArray();
        gArray.push(22);
        gArray.lookup(2);
    }

    @Test
    public void testPush() {
        GArray gArray = new GArray();
        gArray.push(23);
        assertThat(gArray.length()).isEqualTo(1);
        assertThat(gArray.size()).isEqualTo(2);

        gArray.push(55);
        assertThat(gArray.length()).isEqualTo(2);
        assertThat(gArray.size()).isEqualTo(4);

        gArray.push(105);
        assertThat(gArray.length()).isEqualTo(3);
        assertThat(gArray.size()).isEqualTo(8);

        gArray.push(200);
        assertThat(gArray.length()).isEqualTo(4);
        assertThat(gArray.size()).isEqualTo(8);
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopError1() {
        GArray gArray = new GArray();
        gArray.push(20);
        gArray.pop();
        gArray.pop();
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopError2() {
        GArray gArray = new GArray();
        gArray.pop();
    }

    @Test
    public void testPop() {
        GArray gArray = new GArray();
        gArray.push(20);
        gArray.push(30);
        gArray.push(40);

        int pop = gArray.pop();
        assertThat(pop).isEqualTo(40);

        assertThat(gArray.length()).isEqualTo(2);
    }

    @Test
    public void testDelete() {
        GArray gArray = new GArray();
        gArray.push(1);
        gArray.push(2);
        gArray.push(3);
        gArray.push(4);
        gArray.push(5);

        assertThat(gArray.length()).isEqualTo(5);
        gArray.delete(2);
        assertThat(gArray.length()).isEqualTo(4);
        assertThat(gArray.lookup(2)).isEqualTo(4);
    }

    @Test(expected = NoSuchElementException.class)
    public void testDeleteError() {
        GArray gArray = new GArray();
        gArray.push(1);
        gArray.push(2);
        gArray.push(3);
        gArray.push(4);
        gArray.push(5);

        assertThat(gArray.length()).isEqualTo(5);
        gArray.delete(2);
        assertThat(gArray.length()).isEqualTo(4);
        assertThat(gArray.lookup(2)).isEqualTo(4);

        gArray.delete(5);
    }

    @Test
    public void testInsert() {
        GArray gArray = new GArray();
        gArray.insert(2, 20);

        assertThat(gArray.length()).isEqualTo(1);
        assertThat(gArray.lookup(0)).isEqualTo(20);

        gArray.push(100);
        gArray.push(200);
        gArray.push(300);
        gArray.push(400);
        gArray.push(500);

        assertThat(gArray.length()).isEqualTo(6);

        gArray.insert(2, 99);
        assertThat(gArray.length()).isEqualTo(7);
        assertThat(gArray.lookup(3)).isEqualTo(200);
        assertThat(gArray.lookup(1)).isEqualTo(100);
        assertThat(gArray.lookup(2)).isEqualTo(99);

        gArray.push(600);
        assertThat(gArray.length()).isEqualTo(8);
        assertThat(gArray.lookup(7)).isEqualTo(600);
        assertThat(gArray.pop()).isEqualTo(600);


    }
}
