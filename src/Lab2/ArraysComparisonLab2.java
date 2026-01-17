package Lab2;

import java.util.Arrays;

public class ArraysComparisonLab2 {
    // Даны два одномерных целочисленных массива. Произвести поиск заданного значения в первом из них –
    // методом последовательного перебора с использованием барьерного элемента, а во втором – бинарный поиск,
    // предварительно отсортировав этот массив методом вставки.
    // Первый массив отсортировать затем выбором наименьшего элемента. Произвести слияние полученных массивов

    private static final int[] array1 = {12, 14, 22, 4};
    private static final int[] array2 = {0, 1, 4, 5};

    private static int sequential_search_with_barrier(int value) {
        // Поиск последовательным перебором

        int[] tempArray = Arrays.copyOf(array1, array1.length + 1);
        tempArray[tempArray.length - 1] = value;
        int i = 0;
        while (tempArray[i] != value) {
            i++;
        }
        return i < array1.length ? i : -1;
    }

    private static void selection_sort() {
        // Сортировка выбором минимального элемента

        for (int i = 0; i < array1.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array1.length; j++) {
                if (array1[j] < array1[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array1[i];
            array1[i] = array1[minIndex];
            array1[minIndex] = temp;
        }
    }

    private static void insertion_sort() {
        // Сортировка методов вставки

        for (int i = 1; i < array2.length; i++) {
            int key = array2[i];
            int j = i - 1;
            while (j >= 0 && array2[j] > key) {
                array2[j + 1] = array2[j];
                j--;
            }
            array2[j + 1] = key;
        }
    }

    private static int binary_search(int value) {
        // Бинарный поиск

        int low = 0;
        int high = array2.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array2[mid] == value) {
                return mid;
            } else if (array2[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int[] merge_arrays() {
        // Слияние массивов

        int[] mergedArray = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                mergedArray[k++] = array1[i++];
            } else {
                mergedArray[k++] = array2[j++];
            }
        }
        while (i < array1.length) {
            mergedArray[k++] = array1[i++];
        }
        while (j < array2.length) {
            mergedArray[k++] = array2[j++];
        }
        return mergedArray;
    }

    public static void calc(int value) {
        System.out.println("Поиск " + value + " в первом массиве методом последовательного перебора с барьерным элементом: " + sequential_search_with_barrier(value));

        System.out.println("Сортировка первого массива выбором наименьшего элемента:");
        selection_sort();
        System.out.println(Arrays.toString(array1));

        System.out.println("Сортировка второго массива методом вставки:");
        insertion_sort();
        System.out.println(Arrays.toString(array2));

        System.out.println("Поиск " + value + " во втором массиве бинарным поиском: " + binary_search(value));
    }
}
