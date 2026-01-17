package Lab2;

public class ArrayCalcsLab2 {
    public static void calc() {
        // Получить ответ
        double[] array = {1.1, -2, 3.5, 4,643, -5.5, 6, 7};

        System.out.println("Произведение всех положительных чисел: " + get_positives_multiplication(array));
        System.out.println("Сумма чисел до минимального элемента: " + sum_before_min_element(array));
    }

    public static String get_positives_multiplication(double[] raw_array) {
        // Произведение всех положительных чисел

        double res = 1;

        for (double element : raw_array) {
            if (element > 0) {
                res *= element;
            }
        }

        return Double.toString(res);
    }

    public static String sum_before_min_element(double[] raw_array) {
        // Сумма чисел до минимального элемента

        double minElement = Double.MAX_VALUE;
        int minIndex = -1;
        double res = 0;

        for (int i = 0; i < raw_array.length; i++) {
            if (raw_array[i] < minElement) {
                minElement = raw_array[i];
                minIndex = i;
            }
        }

        for (int i = 0; i < minIndex; i++) {
            res += raw_array[i];
        }

        return Double.toString(res);
    }
}
