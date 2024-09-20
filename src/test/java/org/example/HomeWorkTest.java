package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class HomeWorkTest {

    @Test
    void findMaxDigitsTest() {
        HomeWork tree = new HomeWork();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);

        List<Integer> result = tree.findMaxDigits(3, 4);
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(Arrays.asList(4, 3, 2), result);
    }
}