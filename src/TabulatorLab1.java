public class TabulatorLab1 {
    // Составить программу вычисления и печати таблицы значений функции при заданных значениях параметров

    private final static double a = 12.122;
    private final static double b = -16.31;

    private final static double Xn=-0.16, Xk=1, dX=0.2;

    public static void get_tab() {
        System.out.println("\tx\t\ty");

        double x = Xn;
        double y;

        while (x <= Xk) {
            if (a * x < b) {
                y = Math.log(Math.abs(a - Math.pow(x, 3)));
            }
            else if (a * x > b) {
                y = a / (x - b);
            }
            else {
                y = Math.pow(Math.log(a * x + b), 2) - 2.75 * ((a * b * x) / Math.sqrt(a * a + b * x));
            }

            System.out.print(String.format("%.3f", x));
            System.out.println("\t\t" + String.format("%.3f", y));

            x += dX;
        }
    }
}
