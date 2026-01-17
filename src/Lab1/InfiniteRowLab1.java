package Lab1;

public class InfiniteRowLab1 {
    // Составить программу вычисления и печати таблицы значений функции, которая является суммой бесконечного ряда

    private final static double Xn = 0.1, Xk = 0.9, prdX = 0.1;
    private final static double eps = 0.0001;

    public static String calc() {
        StringBuilder res = new StringBuilder();

        double x = Xn;
        res.append("x\t\ty\n");

        while (x <= Xk) {
            double T = 1, y = 0;
            int n = 0;

            while (Math.abs(T) > eps) {
                y += T;
                T *= Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / (4 * n * n - 1);
                n += 1;
            }

            res.append(String.format("%.3f", x)).append("\t\t").append(String.format("%.3f", y)).append("\n");

            x += prdX;
        }

        return res.toString();
    }
}
