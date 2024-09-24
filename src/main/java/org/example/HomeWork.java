package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


@SuppressWarnings("ClassEscapesDefinedScope")
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
     * @param count      максимальное количество элементов в ответе
     * @param upperBound верхняя граница для поиска элементов
     * @return массив найденных максимальных значений не более чем upperBound и длиной не более count, отсортировано от большего к меньшему
     * Сигнатуру метода не меняем
     */
    public List<Integer> findMaxDigits(int count, int upperBound) {
        if (count <= 0) return Collections.emptyList();

        Node suitableNode = findSuitableNode(root, upperBound);
        if (suitableNode == null) return Collections.emptyList();

        Stack<Integer> result = new Stack<>();
        getStackFromTree(root, result, upperBound);


        while (result.peek() != upperBound) {
            result.pop();
        }
        List<Integer> resultList = new ArrayList<>();

        while (count-- > 0) {
            resultList.add(result.pop());
        }

        return resultList;
    }

    private void getStackFromTree(Node root, Stack<Integer> result, int upperBound) {
        if (root == null) return;
        getStackFromTree(root.left, result, upperBound);
        result.push(root.value);
        if (root.value == upperBound) {
            return;
        }
        getStackFromTree(root.right, result, upperBound);
    }

    public Node findSuitableNode(Node root, int val) {
        if (root == null) return null;
        if (root.value == val) return root;
        if (val > root.value) return findSuitableNode(root.right, val);
        else return findSuitableNode(root.left, val);
    }

    public void traversePreOrder(StringBuilder sb, String padding, String pointer, Node node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.value);
            sb.append("\n");

            String paddingForBoth = padding + "│  ";
            String pointerForRight = "└──";
            String pointerForLeft = (node.right != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.left);
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.right);
        }
    }


}
