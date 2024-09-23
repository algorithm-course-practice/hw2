package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryIntSearchTreeTest {

    @Test
    void add() {
        BinaryIntSearchTree tree = new BinaryIntSearchTree();

        tree.add(5);

        for (int i = -100; i < 100; i++) {
            tree.add(i);
        }
        tree.add(10);
        tree.add(-5);
    }
    @Test
    void findMaxDigitsWithHomeExampleData() {
        HomeWork homeWork = new HomeWork();
        assertEquals(null, homeWork.findMaxDigits(10, 10));

        homeWork.add(5);
        homeWork.add(3);
        homeWork.add(1);
        homeWork.add(2);
        homeWork.add(4);
        homeWork.add(8);
        homeWork.add(7);
        homeWork.add(6);
        homeWork.add(10);
        homeWork.add(9);
        assertEquals(List.of(1), homeWork.findMaxDigits(1, 1));
        assertEquals(List.of(2, 1), homeWork.findMaxDigits(2, 2));
        assertEquals(List.of(2), homeWork.findMaxDigits(1, 2));
        assertEquals(List.of(3, 2, 1), homeWork.findMaxDigits(3, 3));
        assertEquals(List.of(4, 3, 2, 1), homeWork.findMaxDigits(4, 4));
        assertEquals(List.of(5, 4), homeWork.findMaxDigits(2, 5));
        assertEquals(List.of(5, 4, 3, 2, 1), homeWork.findMaxDigits(5, 5));
        assertEquals(List.of(6, 5, 4, 3, 2, 1), homeWork.findMaxDigits(6, 6));
        assertEquals(List.of(7, 6, 5, 4, 3, 2, 1), homeWork.findMaxDigits(7, 7));
    }


    @Test
    void findMaxWithIncreaseData() {
        HomeWork homeWork = new HomeWork();

        for (int i = -10; i <= 11; i++) {
            homeWork.add(i);
        }
        assertEquals(List.of(10, 9, 8, 7, 6), homeWork.findMaxDigits(5, 10));
        assertEquals(List.of(), homeWork.findMaxDigits(0, 10));
        assertEquals(List.of(10,9,8,7,6,5,4,3,2,1,0), homeWork.findMaxDigits(11, 10));
        assertEquals(List.of(10,9,8,7,6,5,4,3,2,1,0, -1), homeWork.findMaxDigits(12, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> homeWork.findMaxDigits(42, 10));

        HomeWork homeWork2 = new HomeWork();
        for (int i = 0; i <= 10; i++) {
            homeWork2.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> homeWork2.findMaxDigits(5, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> homeWork2.findMaxDigits(500, 10));
    }

    @Test
    void findMaxWithDecreaseData() {
        HomeWork homeWork = new HomeWork();
        for (int i = 10; i >= 0; i--) {
            homeWork.add(i);
        }
        assertEquals(List.of(10, 9, 8, 7, 6), homeWork.findMaxDigits(5, 10));
        assertEquals(List.of(), homeWork.findMaxDigits(0, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> homeWork.findMaxDigits(7, -7));
        assertThrows(IndexOutOfBoundsException.class, () -> homeWork.findMaxDigits(17, 5));
    }
}