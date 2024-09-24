package org.example;

import java.util.ArrayList;
import java.util.List;


public class HomeWork extends BinaryIntSearchTree {

    /**
     * <h1>Задание 1.</h1>
     * Дан класс BinaryTree, который реализует бинарное дерево поиска.
     * Реализовать метод findMaxDigits, который возвращает массив
     * наибольших элементов в дереве, не превосходящих upperBound.
     * <br/>
     * Пример :
     * коллекция в дереве 1, 2, 3, 4, 5
     * count = 3, upperBound 4
     * ответ [4, 3, 2]

     *
     * @param count максимальное количество элементов в ответе
     * @param upperBound верхняя граница для поиска элементов
     * @return массив найденных максимальных значений не более чем upperBound и длиной не более count, отсортировано от большего к меньшему
     * Сигнатуру метода не меняем
     */
    public List<Integer> findMaxDigits(int count, int upperBound) {
        //TODO реализовать метод
        List<Integer> result = new ArrayList<>();
        findMaxDigitsHelper(root, upperBound, count, result);
        return result;

    }

    // Вспомогательный рекурсивный метод для обратного обхода дерева и сбора подходящих элементов
    private void findMaxDigitsHelper(Node node, int upperBound, int count, List<Integer> result) {
        if (node == null || result.size() >= count) {
            return;
        }

        // Обратный обход: сначала правое поддерево (большие элементы)
        if (node.right != null) {
            findMaxDigitsHelper(node.right, upperBound, count, result);
        }

        // Останавливаем поиск, если нашли достаточное количество элементов
        if (result.size() >= count) {
            return;
        }

        // Проверяем текущий элемент
        if (node.value <= upperBound) {
            result.add(node.value);  // Добавляем элемент в список, если он не превышает upperBound
        }


        // Переходим в левое поддерево (меньшие элементы)
        if (node.left != null) {
            findMaxDigitsHelper(node.left, upperBound, count, result);
        }
    }

    public static void main(String[] args) {
        HomeWork homeWork = new HomeWork();
        homeWork.add(1);
        homeWork.add(2);
        homeWork.add(3);
        homeWork.add(4);
        homeWork.add(5);

        List<Integer> result = homeWork.findMaxDigits(3, 4);
        for (int i : result) {
            System.out.println(i); // Ожидаемый результат: 4, 3, 2
        }

    }


}
