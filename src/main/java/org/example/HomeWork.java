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
        List<Integer> result = new ArrayList<>();
        findMaxDigitsRecursive(root, count, upperBound, result);
        return result;
    }

    private void findMaxDigitsRecursive(Node node, int count, int upperBound, List<Integer> result) {
        if (node == null || result.size() >= count){
            return;
        }
        //обход right
        findMaxDigitsRecursive(node.right, count, upperBound, result);

        //добавляем по условию
        if (node.value <= upperBound && result.size() < count){
            result.add(node.value);
        }

        findMaxDigitsRecursive(node.left, count, upperBound, result);
    }
}
