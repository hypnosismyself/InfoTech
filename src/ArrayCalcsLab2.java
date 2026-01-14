public class ArrayCalcsLab2 {
    static final double[] raw_array = {5, 4.4, 0, -5, 12.5};

    public static void calc() {
        System.out.println("Произведение всех положительных чисел: " + get_positives_multiplication());
        System.out.println("Сумма чисел до минимального элемента: " + sum_before_min_element());
    }

    private static double get_positives_multiplication() {
        double res = 1;

        for (double element : raw_array) {
            if (element > 0) {
                res *= element;
            }
        }

        return res;
    }

    private static double sum_before_min_element() {
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

        return res;
    }
}
