package org.example;

import java.util.ArrayList;
import java.util.Collections;
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
        if (root == null) {
            return null;
        } else {
            // проходим по всему дереву и добавлем все значения не больше upperBound в список
            Node current = root;
            List<Integer> list = new ArrayList<>();
            addValues(current, list, upperBound);
            // сортируем в порядке убывания
            Collections.sort(list, Collections.reverseOrder());
            // возвращаем нужное количество
            if (count > list.size() || count < 0) {
                throw new IndexOutOfBoundsException("Incorrect toIndex argument");
            }
            return list.subList(0, count);
        }
    }

    private void addValues(Node current, List<Integer> list, int upperBound) {
        if (current != null) {
            if (current.value <= upperBound) {
                list.add(current.value);
            }
            addValues(current.left, list, upperBound);
            addValues(current.right, list, upperBound);
        }
    }


}
