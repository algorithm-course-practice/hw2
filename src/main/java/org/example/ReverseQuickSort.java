package org.example;

import java.util.List;

public class ReverseQuickSort {

    public static void quickSort(List<Integer> array) {
        quickSort(array, 0, array.size() - 1);
    }

    private static void quickSort(List<Integer> array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }

    private static int partition(List<Integer> array, int p, int r) {
        int i = p - 1;
        int j = p;
        while (j < r) {
            if (array.get(j) > array.get(r)) {
                swap(array, i + 1, j);
                i++;
            }
            j++;
        }
        swap(array, i + 1, r);
        return i + 1;
    }

    private static void swap(List<Integer> array, int i, int j) {
        int tmp = array.get(i);
        array.set(i,  array.get(j));
        array.set(j, tmp);
    }
}


//class ReverseQuickSortTest {
//    public static void main(String[] args) {
//        List<Integer> array = new ArrayList<>();
//        array.add(2);
//        array.add(8);
//        array.add(7);
//        array.add(3);
//        array.add(5);
//        array.add(6);
//        array.add(4);
//        System.out.println("Before Array: " + array);
//        ReverseQuickSort.quickSort(array);
//        System.out.println("After Array: " + array);
//
//    }
//}
