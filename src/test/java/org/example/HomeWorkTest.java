package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkTest {

    @Test
    void findMaxDigits() {
        //коллекция в дереве 1, 2, 3, 4, 5
        HomeWork homeWork = new HomeWork();
        homeWork.add(1);
        homeWork.add(2);
        homeWork.add(3);
        homeWork.add(4);
        homeWork.add(5);
        //count = 3, upperBound 4 ожидается [4, 3, 2]
        assertEquals(List.of(4, 3, 2), homeWork.findMaxDigits(3, 4));

    }
}