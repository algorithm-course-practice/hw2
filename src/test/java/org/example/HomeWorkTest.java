package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class HomeWorkTest {
    private final BinaryIntSearchTree tree = new BinaryIntSearchTree();
    @BeforeEach
    void setUp() {

        tree.add(5);
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(4);
        tree.add(8);
        tree.add(7);
        tree.add(6);
        tree.add(10);
        tree.add(9);


    }

    @Test
    void findMaxDigits() {
        HomeWork hw = new HomeWork();
        assertThrows(IllegalArgumentException.class, () -> hw.findMaxDigits(1, 1));

        hw.add(5);
        hw.add(3);
        hw.add(1);
        hw.add(2);
        hw.add(4);
        hw.add(8);
        hw.add(7);
        hw.add(6);
        hw.add(10);
        hw.add(9);
        assertEquals(List.of(1), hw.findMaxDigits(1, 1));
        assertEquals(List.of(2, 1), hw.findMaxDigits(2, 2));
        assertEquals(List.of(3, 2, 1), hw.findMaxDigits(3, 3));
        assertEquals(List.of(4, 3, 2, 1), hw.findMaxDigits(4, 4));
        assertEquals(List.of(5, 4, 3, 2, 1), hw.findMaxDigits(5, 5));
        assertEquals(List.of(6, 5, 4, 3, 2, 1), hw.findMaxDigits(6, 6));
        assertEquals(List.of(7, 6, 5, 4, 3, 2, 1), hw.findMaxDigits(7, 7));
    }


    @Test
    void findMax() {
        HomeWork hw = new HomeWork();

        for (int i = 0; i <= 10; i++) {
            hw.add(i);
        }

        assertEquals(List.of(10, 9, 8), hw.findMaxDigits(3, 10));
    }
}