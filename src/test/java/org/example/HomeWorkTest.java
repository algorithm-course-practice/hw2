package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HomeWorkTest {

    private static HomeWork getHomeWork() {
        HomeWork homeWork = new HomeWork();
        homeWork.add(10);
        homeWork.add(5);
        homeWork.add(6);
        homeWork.add(2);
        homeWork.add(7);
        homeWork.add(11);
        homeWork.add(4);
        homeWork.add(3);
        return homeWork;
    }

    private static List<Integer> getReverseOrderListExpected(){
        return Stream.of(
                2,
                3,
                4,
                5,
                6,
                7,
                10,
                11
        ).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    @Test
    public void findMaxTest(){
        HomeWork homeWork = getHomeWork();
        List<Integer> expected = List.of(5,4,3);

        List<Integer> maxDigits = homeWork.findMaxDigits(3, 5);

        assertEquals(expected, maxDigits);
    }

    @Test
    public void findMaxNoNodeTest(){
        HomeWork homeWork = getHomeWork();

        Assertions.assertTrue(homeWork.findMaxDigits(3, -5).isEmpty());
        Assertions.assertTrue(homeWork.findMaxDigits(3, 20).isEmpty());
        Assertions.assertTrue(homeWork.findMaxDigits(3, 8).isEmpty());
        Assertions.assertTrue(homeWork.findMaxDigits(0, 5).isEmpty());
        Assertions.assertTrue(homeWork.findMaxDigits(-5, 5).isEmpty());

    }



    @Test
    public void findMaxBigCountTest(){
        HomeWork homeWork = getHomeWork();
        assertEquals(getReverseOrderListExpected(), homeWork.findMaxDigits(8, 11));
    }

    @Test
    public void findSuitableNodeTest() {
        HomeWork homeWork = getHomeWork();

        assertEquals(6, homeWork.findSuitableNode(homeWork.root, 6).value);
        assertNull(homeWork.findSuitableNode(homeWork.root, 20));
    }

    @Test
    public void printBSTDiagram(){
        HomeWork homeWork = getHomeWork();
        StringBuilder sb = new StringBuilder();
        homeWork.traversePreOrder(sb,"","",homeWork.root);
        System.out.println(sb);
    }

}