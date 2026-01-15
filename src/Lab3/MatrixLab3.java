package Lab3;

public class MatrixLab3 {
    // Дана целочисленная прямоугольная матрица. Определить:
    // 1) количество отрицательных элементов в тех строках, которые содержат хотя бы один нулевой элемент.
    // 2) Максимальное значение среди средних арифметических значений в каждом столбце матрицы

    private final static int[][] matrix = {
            {1, -2, 0, 4},
            {5, 0, -3, 7},
            {8, 9, 10, 11}
    };

    private static int count_negative_in_zero_rows() {
        // Определить количество отрицательных элементов в строках с нулевыми элементами

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean hasZero = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    hasZero = true;
                    break;
                }
            }
            if (hasZero) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] < 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static double max_average_in_columns() {
        // Определить максимальное значение среди средних арифметических значений в каждом столбце матрицы

        double maxAverage = Double.NEGATIVE_INFINITY;
        for (int j = 0; j < matrix[0].length; j++) {
            double sum = 0.0;
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][j];
            }
            double average = sum / matrix.length;
            if (average > maxAverage) {
                maxAverage = average;
            }
        }
        return maxAverage;
    }

    public static void calc() {
        System.out.println("Количество отрицательных элементов в строках с нулевыми элементами: " + count_negative_in_zero_rows());
        System.out.println("Максимальное значение среди средних в каждом столбце: " + max_average_in_columns());
    }
}
