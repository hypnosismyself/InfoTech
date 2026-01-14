public class InfiniteRowLab1 {
    private final static double Xn = 0.1, Xk = 0.9, prdX = 0.1;
    private final static double eps = 0.0001;

    public static void get_row() {
        double x = Xn;
        System.out.println("\tx\t\ty");

        while (x <= Xk) {
            double T = 1, y = 0;
            int n = 0;

            while (Math.abs(T) > eps) {
                y += T;
                T *= Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / (4 * n * n - 1);
                n += 1;
            }

            System.out.print(String.format("%.3f", x));
            System.out.println("\t\t" + String.format("%.3f", y));

            x += prdX;
        }
    }
}
